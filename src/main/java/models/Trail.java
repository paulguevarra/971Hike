package models;

import java.text.DecimalFormat;
import java.util.ArrayList;

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
    private int userId;
    private static ArrayList<Trail> trailList = new ArrayList<>();


    public Trail(String trailName, String difficulty, String location, Integer latitude, Integer longitude, Integer maxDistance, int userId) {
        this.trailName = trailName;
        this.difficulty = difficulty;
        this.location = location;
        this.latitude = latitude;
        this.longitude = longitude;
        this.maxDistance = maxDistance;


        this.userId = userId;
        trailList.add(this);
        this.id=trailList.size();
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public static ArrayList<Trail> getAllTrails(){
        return trailList;
    }
    public static void deleteAllTrails(){
        trailList.clear();
    }
    public static Trail findTrailById(int id){
        return trailList.get(id-1);
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
        return userId!=that.userId;
    }

    @Override
    public int hashCode() {
        int result = trailName.hashCode();
        result = 31 * result + difficulty.hashCode();
        result = 31 * result + location.hashCode();
        result = 31 * result + latitude.hashCode();
        result = 31 * result + longitude.hashCode();
        result = 31 * result + maxDistance.hashCode();
        result = 31 * result + userId;
        result = 31 * result + id;
        return result;
    }

}


