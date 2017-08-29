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



    //helper
    public Trail setupNewTrail(){
        return new Trail ("Trail of Tears", "deadly", "Oregon", 116.359998, -116.359998, 500, 12);
    }
    public Trail setupNewTrail2(){
        return new Trail ("Pacific Crest", "high", "California", 116.359998, -116.359998, 3, 200);
    }

}