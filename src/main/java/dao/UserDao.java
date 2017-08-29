package dao;

import models.User;

import java.util.List;

/**
 * Created by Guest on 8/24/17.
 */
public interface UserDao {

    void add(User user);

    List<User> getAll(); //Read

    User findById(int id); // Find user by id

    void deleteById(int id); //Delete

    void clearAllUsers(); // Delete all
}
