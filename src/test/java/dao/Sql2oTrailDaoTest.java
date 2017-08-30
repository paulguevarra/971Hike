package dao;

import models.Trail;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.Assert.*;

public class Sql2oTrailDaoTest {

    private Sql2oTrailDao trailDao;
    private Connection conn;

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString,"","");
        trailDao = new Sql2oTrailDao(sql2o);
        conn = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        conn.close();
    }

    @Test
    public void addingCourseSetsId() throws Exception {
        Trail newTrail = setupNewTrail();
        int originalTrailId = newTrail.getId();
        trailDao.add(newTrail);
        assertNotEquals(originalTrailId, newTrail.getId());
    }

    @Test
    public void addedTrailsAreReturnedFromGetAll() throws Exception {
        Trail newTrail = setupNewTrail();
        trailDao.add(newTrail);
        assertEquals(1,trailDao.getAll().size());
    }

    @Test
    public void noTrailsRetursEmptyList() throws Exception {
        assertEquals(0, trailDao.getAll().size());
    }

    @Test
    public void existingTrailsCanBeFoundById() throws Exception {
        Trail trail = setupNewTrail();
        trailDao.add(trail);
        Trail foundTrail = trailDao.findById(trail.getId());
        assertEquals(trail, foundTrail);
    }

    @Test
    public void updateChangesTrailContents() throws Exception {
        Trail trail = setupNewTrail();
        trailDao.add(trail);
        trailDao.update(trail.getId(),"Pacific Crest","high","California",5.5);
        Trail updatedTrail = trailDao.findById(trail.getId());
        assertNotEquals(trail,updatedTrail);
    }

    @Test
    public void deleteByIdDeletesCorrectWords() throws Exception {
        Trail testTrail = setupNewTrail();
        Trail altTrail = setupNewTrail2();
        trailDao.add(testTrail);
        trailDao.add(altTrail);
        trailDao.deleteById(testTrail.getId());
        assertEquals(1, trailDao.getAll().size());
    }

    //helper
    public Trail setupNewTrail(){
        return new Trail ("Lewis & Clark", "high", "Oregon", 500.2);
    }
    public Trail setupNewTrail2(){
        return new Trail ("Pacific Crest", "high", "California",  3.7);
    }

}