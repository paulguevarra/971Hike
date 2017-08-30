package dao;

import models.Journal;

import java.util.List;


public interface JournalDao {

    void add(Journal journal);

    List<Journal> getAll(); //Read

    Journal findById(int id); // Find journal by id

    List<Journal> findByTrailId(int trailId);

    List<Journal> findByTrailIdAndUserId (int trailId, int userId)
;
    void update(int id, int trailId, int userId, String createdAt, String bestSeason, String didTheHike, String notes);//update

    void deleteById(int id); //Delete

    void deleteJournalByTrailId(int trailId);

    void clearAllJournals(); // Delete all
}
