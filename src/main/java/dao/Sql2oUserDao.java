package dao;


import models.Trail;
import models.Journal;
import models.User;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;
public class Sql2oUserDao implements UserDao {

    private final Sql2o sql2o;

    public Sql2oUserDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public void add(User user) {
        String sql = "INSERT INTO users (userName, userLocation, userMaxDistance) VALUES (:username, :userlocation, :usermaxdistance)";
        try (Connection con = sql2o.open()) {
            int id = (int) con.createQuery(sql)
                    .addParameter("username", user.getUserName())
                    .addParameter("userlocation", user.getUserLocation())
                    .addParameter("usermaxdistance", user.getUserMaxDistance())
                    .addColumnMapping("USERNAME", "userName")
                    .addColumnMapping("USERLOCATION", "userLocation")
                    .addColumnMapping("USERMAXDISTANCE", "userMaxDistance")
                    .executeUpdate()
                    .getKey();
            user.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public List<User> getAll() {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM users")
                    .executeAndFetch(User.class);
        }
    }

    @Override
    public User findById(int id) {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM users WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(User.class);
        }
    }

    @Override
    public void update(int id, String newUserName, String newUserLocation, Double newUserMaxDistance) {
        String sql = "UPDATE users SET (userName, userLocation, userMaxDistance) = (:username, :userlocation, :usermaxdistance) WHERE id=:id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("username", newUserName)
                    .addParameter("userlocation", newUserLocation)
                    .addParameter("usermaxdistance", newUserMaxDistance)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void deleteUserById(int id) {
        String sql = "DELETE from users WHERE id=:id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void clearAllUsers() {
        String sql = "DELETE from users";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

//    @Override
//    public List<Journal> getAllJournalByUser(int userId) {
//        try (Connection con = sql2o.open()) {
//            return con.createQuery("SELECT * FROM journals WHERE userId = :userid")
//                    .addParameter("userid", userId)
//                    .executeAndFetch(Journal.class);
//        }
//
//    }
}