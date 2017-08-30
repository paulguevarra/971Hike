package dao;

import models.Journal;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

import static org.junit.Assert.*;

public class Sql2oJournalDaoTest {

    private Connection conn;
    private Sql2oJournalDao journalDao;

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        journalDao = new Sql2oJournalDao(sql2o);
        conn = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        conn.close();;
    }

    @Test
    public void journalInstantiatesCorrectly() throws Exception{
        Journal newJournal = testJournal();
        assertTrue(newJournal instanceof Journal);
    }

    @Test
    public void getAll() throws Exception{
        Journal newJournal = testJournal();
        Journal newJournal2 = testJournal2();
        journalDao.add(newJournal);
        journalDao.add(newJournal2);
        assertEquals(2, journalDao.getAll().size());
    }

    @Test
    public void findByTrailId() throws Exception {
        Journal newJournal = testJournal();
        Journal otherJournal = new Journal("6/23/2017", 2, 2, "Spring", "did the whole hike", "great picnic spot");
        journalDao.add(newJournal);
        journalDao.add(otherJournal);
        List<Journal> foundJournal = journalDao.findByTrailId(1);
        assertEquals(1, foundJournal.size());
    }

    @Test
    public void findByTrailIdAndUserId() throws Exception {
        Journal newJournal = testJournal();
        Journal testJournal = testJournal2();
        Journal otherJournal = new Journal("6/23/2017", 2, 2, "Spring", "did the whole hike", "great picnic spot");
        journalDao.add(newJournal);
        journalDao.add(otherJournal);
        journalDao.add(testJournal);
        List<Journal> foundJournal = journalDao.findByTrailIdAndUserId(1, 2);
        assertEquals(1, foundJournal.size());
    }

    @Test
    public void addingJournalSetsId() throws Exception {
        Journal newJournal = testJournal();
        int oldId = newJournal.getId();
        journalDao.add(newJournal);
        Journal foundJournal = journalDao.findById(1);
        assertNotEquals(oldId, foundJournal.getId());
    }

    @Test
    public void updateJournal(){
        Journal newJournal = testJournal();
        int oldTrail = newJournal.getTrailId();
        journalDao.add(newJournal);
        journalDao.update(1, 2, 1, "8/8/2017","summer", "did the whole hike", "gorgeous wildflowers; needs poles for gravel bits");
        Journal foundJournal = journalDao.findById(1);
        assertNotEquals(oldTrail, foundJournal.getTrailId());
    }

    @Test
    public void deleteById(){
        Journal newJournal = testJournal();
        Journal newJournal2 = testJournal2();
        journalDao.add(newJournal);
        journalDao.add(newJournal2);
        journalDao.deleteById(1);
        assertEquals(1, journalDao.getAll().size());
        Journal foundJournal = journalDao.findById(2);
        assertEquals("Spring", foundJournal.getBestSeason());
    }

    @Test
    public void deleteJournalsByTrailId(){
        Journal newJournal = testJournal();
        Journal otherJournal = new Journal("6/23/2017", 2, 2, "Spring", "did the whole hike", "great picnic spot");
        journalDao.add(newJournal);
        journalDao.add(otherJournal);
        journalDao.deleteJournalByTrailId(2);
        assertEquals(1, journalDao.getAll().size());
    }

    @Test
    public void clearAllJournals(){
        Journal newJournal = testJournal();
        Journal newJournal2 = testJournal2();
        journalDao.add(newJournal);
        journalDao.add(newJournal2);
        int daoSize = journalDao.getAll().size();
        journalDao.clearAllJournals();
        assertNotEquals(daoSize, journalDao.getAll().size());
    }


    //helper
    public Journal testJournal(){
        return new Journal ("8/8/2017", 1, 1,  "summer", "did the whole hike", "gorgeous wildflowers; needs poles for gravel bits");
    }

    public Journal testJournal2(){
        return new Journal ("6/23/2017", 1, 2, "Spring", "did the whole hike", "great picnic spot");
    }
}