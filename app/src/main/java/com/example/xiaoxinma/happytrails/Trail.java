package com.example.xiaoxinma.happytrails;

import java.util.ArrayList;

/**
 * Created by XiaoxinMa on 4/30/17.
 */

public class Trail {
    private String name;
    private int rating;
    private double latitude;
    private double longitude;
    private String state;
    private boolean haveHiked;
    private ArrayList<String> landmarks;
    public Trail next;

    public Trail() {
        name = "";
        rating = 0;
        latitude = 0;
        longitude = 0;
        state = "";
        haveHiked = false;
        landmarks = new ArrayList<String>();
        next = null;
    }

    public Trail(Trail other) {
        this.name = other.getName();
        this.rating = other.getRating();
        this.latitude = other.getLatitude();
        this.longitude = other.getLongitude();
        this.state = other.getState();
        this.haveHiked = other.isHaveHiked();
        this.landmarks = other.getLandmarks();
        this.next = null;
    }

    public Trail(String name, int rating, double latitude, double longitude,
                 String state, boolean haveHiked) {
        this.name = name;
        this.rating = rating;
        this.latitude = latitude;
        this.longitude = longitude;
        this.state = state;
        this.haveHiked = haveHiked;
        this.landmarks = new ArrayList<String>();
        this.next= null;
    }


    public String toString() {
        String result = "" + name + "\n" + rating + "\n" + latitude + "\n" + longitude + "\n" + state + "\n";

        if (haveHiked) {
            result += "*" + "\n";
        } else {
            result += " " + "\n";
        }

        for(int i = 0; i < landmarks.size(); i++) {
            result += this.landmarks.get(i) + "\n";
        }
        return result;
     }

     public void setName(String name) {
        this.name = name;
     }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setHaveHiked(boolean haveHiked) {
        this.haveHiked = haveHiked;
    }

    public void addLandmarks(String landmarks) {
        this.landmarks.add(landmarks);
    }

    public void removeLandmarks(String landmarks) {
        this.landmarks.remove(landmarks);
    }

    public String getName() {
        return this.name;
    }

    public int getRating() {
        return this.rating;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public String getState() {
        return this.state;
    }

    public boolean isHaveHiked() {
        return this.haveHiked;
    }

    public ArrayList<String> getLandmarks() {
        return this.landmarks;
    }



}
