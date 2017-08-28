package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Guest on 8/28/17.
 */
public class TrailTest {
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
        Trail.deleteAllTrails();
    }

    //helper
    public Trail setupNewTrail(){
        return new Trail ("Trail of Tears", "deadly", "Oregon", 9, 11, 500, 12);
    }
    public Trail setupNewTrail2(){
        return new Trail ("Pacific Crest", "high", "California", 50, 3, 200, 49);
    }

    @Test
    public void newTrailObject_CreatedCorrectly() throws Exception {
        Trail testTrail = setupNewTrail();
        assertEquals(true, testTrail instanceof Trail);
    }

    @Test
    public void newTrail_getTrailName_TrailOfTears() throws Exception {
        Trail testTrail = setupNewTrail();
        assertEquals("Trail of Tears", testTrail.getTrailName());
    }

    @Test
    public void newTrail_getDifficulty_deadly() throws Exception {
        Trail testTrail = setupNewTrail();
        assertEquals("deadly", testTrail.getDifficulty());
    }
    @Test
    public void newTrail_getLocation_Oregon() throws Exception {
        Trail testTrail = setupNewTrail();
        assertEquals("Oregon", testTrail.getLocation());
    }
    @Test
    public void newTrail_getLatitude_9() throws Exception {
        Trail testTrail = setupNewTrail();
        assertEquals(Integer.valueOf(9), testTrail.getLatitude());
    }
    @Test
    public void newTrail_getLongitude_11() throws Exception {
        Trail testTrail = setupNewTrail();
        assertEquals(Integer.valueOf(11), testTrail.getLongitude());
    }
    @Test
    public void newTrail_getMaxDistance_500() throws Exception {
        Trail testTrail = setupNewTrail();
        assertEquals(Integer.valueOf(500), testTrail.getMaxDistance());
    }
    @Test
    public void newTrail_getUserId_500() throws Exception {
        Trail testTrail = setupNewTrail();
        assertEquals(12, testTrail.getUserId());
    }
    @Test
    public void newTrail_getTrailId_1() throws Exception {
        Trail testTrail = setupNewTrail();
        assertEquals(1, testTrail.getId());
    }
    @Test
    public void trailList_getAllTrailInstances_2() throws Exception {
        Trail testTrail = setupNewTrail();
        Trail testTrailTwo = setupNewTrail2();
        assertEquals(2, Trail.getAllTrails().size());
    }
    @Test
    public void trailList_deleteAllTrailInstances_0() throws Exception {
        Trail testTrail = setupNewTrail();
        Trail testTrailTwo = setupNewTrail2();
        Trail.deleteAllTrails();
        assertEquals(0, Trail.getAllTrails().size());
    }
    @Test
    public void trailList_findTrailById_0() throws Exception {
        Trail testTrail = setupNewTrail();
        Trail testTrailTwo = setupNewTrail2();
        assertEquals(testTrailTwo, Trail.findTrailById(testTrailTwo.getId()));
    }
}