package models;

import java.text.DecimalFormat;
import java.util.ArrayList;


public class Trail {


    private String trailName;
    private String difficulty;
    private String location;
//    private Double latitude;
//    private Double longitude;
    private Double distance;
    private int id;

    public Trail(String trailName, String difficulty, String location, Double distance) { //Double latitude, Double longitude,
        this.trailName = trailName;
        this.difficulty = difficulty;
        this.location = location;
//        this.latitude = latitude;
//        this.longitude = longitude;
        this.distance = distance;
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

//    public Double getLatitude() {
//        return latitude;
//    }
//
//    public void setLatitude(Double latitude) {
//        this.latitude = latitude;
//    }
//
//    public Double getLongitude() {
//        return longitude;
//    }
//
//    public void setLongitude(Double longitude) {
//        this.longitude = longitude;
//    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Trail trail = (Trail) o;

        if (id != trail.id) return false;
        if (!trailName.equals(trail.trailName)) return false;
        if (!difficulty.equals(trail.difficulty)) return false;
        if (!location.equals(trail.location)) return false;
//        if (!latitude.equals(trail.latitude)) return false;
//        if (!longitude.equals(trail.longitude)) return false;
        return distance.equals(trail.distance);
    }

    @Override
    public int hashCode() {
        int result = trailName.hashCode();
        result = 31 * result + difficulty.hashCode();
        result = 31 * result + location.hashCode();
//        result = 31 * result + latitude.hashCode();
//        result = 31 * result + longitude.hashCode();
        result = 31 * result + distance.hashCode();
        result = 31 * result + id;
        return result;
    }
}


