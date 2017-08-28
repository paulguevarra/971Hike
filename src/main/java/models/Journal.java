package models;

import java.time.LocalDateTime;
import java.sql.Timestamp;


/**
 * Created by Guest on 8/24/17.
 */
public class Journal {

    private int id;
    private Timestamp createdAt;
    private String bestSeason;
    private int trailId;
    private int userId;
    private String didIt;
    private String notes;

    public Journal(String bestSeason, int userId, Timestamp createdAt, int trailId, String didIt, String notes) {
        this.bestSeason = bestSeason;
        this.userId = userId;
        this.createdAt = Timestamp.valueOf(LocalDateTime.now());
        this.didIt = didIt;
        this.notes = notes;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public String getBestSeason() {
        return bestSeason;
    }

    public void setBestSeason(String bestSeason) {
        this.bestSeason = bestSeason;
    }

    public int getTrailId() {
        return trailId;
    }

    public void setTrailId(int trailId) {
        this.trailId = trailId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getDidIt() {
        return didIt;
    }

    public void setDidIt(String didIt) {
        this.didIt = didIt;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Journal journal = (Journal) o;

        if (id != journal.id) return false;
        if (bestSeason != journal.bestSeason) return false;
        if (trailId != journal.trailId) return false;
        if (userId != journal.userId ) return false;
        if (!createdAt.equals(journal.createdAt)) return false;
        if (didIt != journal.didIt) return false;
        return notes != null ? createdAt.equals(journal.notes) : journal.notes == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + bestSeason.hashCode();
        result = 31 * result + trailId;
        result = 31 * result + (notes != null ? notes.hashCode() : 0);
        result = 31 * result + userId;
        result = 31 * result + didIt;
        return result;
    }
}



