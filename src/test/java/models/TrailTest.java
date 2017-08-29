package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TrailTest {
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
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
    public void newTrail_getLatitude_latitude() throws Exception {
        Trail testTrail = setupNewTrail();
        assertEquals(Double.valueOf(116.359998), testTrail.getLatitude());
    }
    @Test
    public void newTrail_getLongitude_longitude() throws Exception {
        Trail testTrail = setupNewTrail();
        assertEquals(Double.valueOf(-116.359998), testTrail.getLongitude());
    }
    @Test
    public void newTrail_getMaxDistance_500() throws Exception {
        Trail testTrail = setupNewTrail();
        assertEquals(Integer.valueOf(500), testTrail.getDistance());
    }
    @Test
    public void newTrail_getUserId_500() throws Exception {
        Trail testTrail = setupNewTrail();
        assertEquals(12, testTrail.getUserId());
    }

    //helper
    public Trail setupNewTrail(){
        return new Trail ("Trail of Tears", "deadly", "Oregon", 116.359998, -116.359998, 500, 12);
    }
    public Trail setupNewTrail2(){
        return new Trail ("Pacific Crest", "high", "California", 116.359998, -116.359998, 3, 200);
    }
}