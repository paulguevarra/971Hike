package models;

import java.time.LocalDateTime;
import java.sql.Timestamp;


public class Journal {

    private int id;
    private String createdAt;
    private String bestSeason;
    private int trailId;
    private int userId;
    private String didTheHike;
    private String notes;

    public Journal(String createdAt, int trailId, int userId, String bestSeason, String didTheHike, String notes) {
        this.createdAt = createdAt;
        this.trailId = trailId;
        this.userId = userId;
        this.bestSeason = bestSeason;
        this.didTheHike = didTheHike;
        this.notes = notes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
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

    public String getDidTheHike() {
        return didTheHike;
    }

    public void setDidTheHike(String didTheHike) {
        this.didTheHike = didTheHike;
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
        if (trailId != journal.trailId) return false;
        if (userId != journal.userId) return false;
        if (!createdAt.equals(journal.createdAt)) return false;
        if (!bestSeason.equals(journal.bestSeason)) return false;
        if (!didTheHike.equals(journal.didTheHike)) return false;
        return notes.equals(journal.notes);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + createdAt.hashCode();
        result = 31 * result + bestSeason.hashCode();
        result = 31 * result + trailId;
        result = 31 * result + userId;
        result = 31 * result + didTheHike.hashCode();
        result = 31 * result + notes.hashCode();
        return result;
    }
}



