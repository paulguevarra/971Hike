package dao;

import models.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.*;


public class Sql2OUserDaoTest {

    private Sql2oUserDao userDao;
    private Sql2oJournalDao journalDao;
    private Sql2oTrailDao trailDao;
    private Connection conn;

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        userDao = new Sql2oUserDao(sql2o);
//        journalDao = new Sql2oJournalDao(sql2o);
        trailDao = new Sql2oTrailDao(sql2o);
        conn = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        conn.close();
    }

    @Test
    public void addingCourseSetsId() throws Exception {
        User user = new User("Ryan", "Portland", 3);
        int originalUserId = user.getId();
        userDao.add(user);
        assertNotEquals(originalUserId, user.getId());
    }


    @Test
    public void existingUsersCanBeFoundById() throws Exception {
        User user = new User("Ryan", "Portland", 3);
        userDao.add(user);
        User found = userDao.findById(user.getId());
        assertNotEquals(user, found);
    }

    @Test
    public void addedUsersAreReturnedFromGetAll() throws Exception {
        User user = new User("Ryan", "Portland", 3);
        userDao.add(user);
        assertEquals(1, userDao.getAll().size());
    }

    @Test
    public void noUserReturnsEmptyList() throws Exception {
        assertEquals(0, userDao.getAll().size());
    }

    @Test
    public void updateChangesUserName() throws Exception {
        String initialUserName = "Ryan";
        User user = new User (initialUserName, "Portland", 5);
        userDao.add(user);
        userDao.update(user.getId(),"Liam", "Boise", 4.5);
        User updatedUser = userDao.findById(user.getId());
        assertNotEquals(initialUserName, updatedUser.getUserName());
    }

    @Test
    public void deleteByIdDeletesCorrectUser() throws Exception {
        User user = new User("Ryan", "Portland", 3);
        userDao.add(user);
        userDao.deleteUserById(user.getId());
        assertEquals(0, userDao.getAll().size());
    }
    @Test
    public void clearAllClearsAll() throws Exception {
        User user = setupNewUser();
        User otherUser = new User("Hogs", "Boring", 6);
        userDao.add(user);
        userDao.add(otherUser);
        int daoSize = userDao.getAll().size();
        userDao.clearAllUsers();
        assertTrue(daoSize > 0 && daoSize > userDao.getAll().size());
    }
//    @Test
//    public void journalIdIsReturnedCorrectly() throws Exception {
//        User user = new User("Ryan", "Portland", 3);
//        int originalJournalId = user.getJournalId();
//        userDao.add(user);
//        assertEquals(originalJournalId, userDao.findById(user.getId()).getJournalId());
//    }
//


    //helper methods
    public User setupNewUser() {
        return new User("Ryan", "Portland", 3);
    }


}