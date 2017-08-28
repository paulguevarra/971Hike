package models;

import java.text.DecimalFormat;

/**
 * Created by Guest on 8/24/17.
 */
public class Trail {


    private String trailName;
    private String difficulty;
    private String location;
    private Integer latitude;
    private Integer longitude;
    private Integer maxDistance;
    private int id;
    private int hikerId;



    public Trail(String trailName, String difficulty, String location, Integer latitude, Integer Longitude, Integer maxDistancem, int hikerId) {
        this.trailName = trailName;
        this.difficulty = difficulty;
        this.location = location;
        this.latitude = latitude;
        this.longitude = longitude;
        this.maxDistance = maxDistance;


        this.hikerId = hikerId;

    }

    public String getTrailName() {
        return trailName;
    }

    public void setTrailName(String trailName) {
        this.trailName = trailName;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getLatitude() {
        return latitude;
    }

    public void setLatitude(Integer latitude) {
        this.latitude = latitude;
    }

    public Integer getLongitude() {
        return longitude;
    }

    public void setLongitude(Integer longitude) {
        this.longitude = longitude;
    }

    public Integer getMaxDistance() {
        return maxDistance;
    }

    public void setMaxDistance(Integer maxDistance) {
        this.maxDistance = maxDistance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHikerId() {
        return hikerId;
    }

    public void setHikerId(int hikerId) {
        this.hikerId = hikerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Trail that = (Trail) o;

        if (id != that.id) return false;
        if (!trailName.equals(that.trailName)) return false;
        if (!difficulty.equals(that.difficulty)) return false;
        if (!location.equals(that.location)) return false;
        if (!latitude.equals(that.latitude)) return false;
        if (!longitude.equals(that.longitude)) return false;
        if (!maxDistance.equals(that.maxDistance)) return false;
        return hikerId!=that.hikerId;
    }

    @Override
    public int hashCode() {
        int result = trailName.hashCode();
        result = 31 * result + difficulty.hashCode();
        result = 31 * result + location.hashCode();
        result = 31 * result + latitude.hashCode();
        result = 31 * result + longitude.hashCode();
        result = 31 * result + maxDistance.hashCode();
        result = 31 * result + hikerId;
        result = 31 * result + id;
        return result;
    }

}


