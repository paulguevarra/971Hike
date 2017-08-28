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
    private Integer distance;
    private int id;
    private int userId;



    public Trail(String trailName, String difficulty, String location, Integer latitude, Integer Longitude, Integer distancem, int userId) {
        this.trailName = trailName;
        this.difficulty = difficulty;
        this.location = location;
        this.latitude = latitude;
        this.longitude = longitude;
        this.distance = distance;
        this.userId = userId;

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

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHikerId() {
        return userId;
    }

    public void setHikerId(int hikerId) {
        this.userId = hikerId;
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
        if (!distance.equals(that.distance)) return false;
        return userId!=that.userId;
    }

    @Override
    public int hashCode() {
        int result = trailName.hashCode();
        result = 31 * result + difficulty.hashCode();
        result = 31 * result + location.hashCode();
        result = 31 * result + latitude.hashCode();
        result = 31 * result + longitude.hashCode();
        result = 31 * result + distance.hashCode();
        result = 31 * result + userId;
        result = 31 * result + id;
        return result;
    }

}


