package dao;


import models.Journal;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oJournalDao implements JournalDao {

    private final Sql2o sql2o;
    public Sql2oJournalDao (Sql2o sql2o){
        this.sql2o = sql2o;
    }

    @Override
    public void add(Journal journal) {
        String sql = "INSERT INTO journals (createdAt, trailId, userId, bestSeason, didTheHike, notes) VALUES (:createdAt, :trailId, :userId, :bestSeason, :didTheHike, :notes)";
        try (Connection con = sql2o.open()){
            int id = (int) con.createQuery(sql)
                    .addParameter("createdAt", journal.getCreatedAt())
                    .addParameter("trailId", journal.getTrailId())
                    .addParameter("userId", journal.getUserId())
                    .addParameter("bestSeason", journal.getBestSeason())
                    .addParameter("didTheHike", journal.getDidTheHike())
                    .addParameter("notes", journal.getNotes())
                    .addColumnMapping("CREATEDAT", "createdAt")
                    .addColumnMapping("TRAILID", "trailId")
                    .addColumnMapping("USERID", "userId")
                    .addColumnMapping("BESTSEASON", "bestSeason")
                    .addColumnMapping("DIDTHEHIKE", "didTheHike")
                    .addColumnMapping("NOTES", "notes")
                    .executeUpdate()
                    .getKey();
            journal.setId(id);
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }

    @Override
    public List<Journal> getAll() {
        String sql = "SELECT * FROM journals";
        try (Connection con = sql2o.open()){
            return con.createQuery(sql)
                    .executeAndFetch(Journal.class);
        }
    }

    @Override
    public Journal findById(int id) {
        String sql = "SELECT * FROM journals WHERE id = :id";
        try (Connection con = sql2o.open()){
            return con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Journal.class);
        }
    }

    @Override
    public List<Journal> findByTrailId(int trailId){
        String sql = "SELECT * FROM journals WHERE trailId = :trailId";
        try (Connection con = sql2o.open()){
            return con.createQuery(sql)
                    .addParameter("trailId", trailId)
                    .executeAndFetch(Journal.class);
        }
    }

    @Override
    public List<Journal> findByTrailIdAndUserId(int trailId, int userId){
        String sql = "SELECT * FROM journals WHERE trailId = :trailId AND userId = :userId ORDER BY id DESC";
        try (Connection con = sql2o.open()){
            return con.createQuery(sql)
                    .addParameter("trailId", trailId)
                    .addParameter("userId", userId)
                    .executeAndFetch(Journal.class);
        }
    }

    @Override
    public void update(int id, int trailId, int userId, String createdAt, String bestSeason, String didTheHike, String notes) {
        String sql = "UPDATE journals SET (trailId, userId, createdAt, bestSeason, didTheHike, notes) = (:trailId, :userId, :createdAt, :bestSeason, :didTheHike, :notes) WHERE id = :id";
        try (Connection con = sql2o.open()){
            con.createQuery(sql)
                    .addParameter("id", id)
                    .addParameter("trailId", trailId)
                    .addParameter("userId", userId)
                    .addParameter("createdAt", createdAt)
                    .addParameter("bestSeason", bestSeason)
                    .addParameter("didTheHike", didTheHike)
                    .addParameter("notes", notes)
                    .executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }

    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE FROM journals WHERE id = :id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }

    @Override
    public void deleteJournalByTrailId(int trailId) {
        String sql = "DELETE FROM journals WHERE trailId = :trailId";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("trailId", trailId)
                    .executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }

    @Override
    public void clearAllJournals() {
        String sql = "DELETE FROM journals";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }


}
