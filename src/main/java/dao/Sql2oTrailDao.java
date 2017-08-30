package dao;

import models.Trail;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;


public class Sql2oTrailDao implements TrailDao{
    private final Sql2o sql2o;

    public Sql2oTrailDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    // have to double check the parameters for add
    @Override
    public void add (Trail trail){
        // Why we need userId here?
        String sql = "INSERT INTO trails (trailName, difficulty, location, distance) VALUES (:trailName, :difficulty, :location, :distance)"; //latitude, longitude, :latitude, :longitude,
        try (Connection con = sql2o.open()){
            int id = (int) con.createQuery(sql)
                    .bind(trail)
                    .executeUpdate()
                    .getKey();
            trail.setId(id);
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }

    @Override
    public List<Trail> getAll() {
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM trails")
                .executeAndFetch(Trail.class);
        }
    }

    @Override
    public Trail findById(int id) {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM trails WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(Trail.class);
        }
    }

    // have to double check the parameters for update
    @Override
    public void update(int id, String trailName, String difficulty, String location, Double distance) { //Double latitude, Double longitude,
        String sql = "UPDATE trails SET (trailname, difficulty, location, distance) = (:trailname, :difficulty, :location, :distance) WHERE id=:id"; //latitude, longitude, :latitude, :longitude,
        try(Connection con = sql2o.open()){
            con.createQuery(sql)
                    .addParameter("trailname", trailName)
                    .addParameter("difficulty", difficulty)
                    .addParameter("location",location)
//                    .addParameter("latitude", latitude)
//                    .addParameter("longitude", longitude)
                    .addParameter("distance", distance)
                    .addParameter("id",id)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE FROM trails WHERE id = :id";
        // do we need a join statement for trails and journals? because trail have journal info that needed to be deleted
        try(Connection con = sql2o.open()){
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }
}
