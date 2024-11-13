package com;

public class Rides {

    private String userId;  // The ID of the user who took this ride
    private double distance; // in kilometers
    private double time;     // in minutes

    // Constructor
    public Rides(String userId, double distance, double time) {
        this.userId = userId;
        this.distance = distance;
        this.time = time;
    }

    // Getters
    public String getUserId() {
        return userId;
    }

    public double getDistance() {
        return distance;
    }

    public double getTime() {
        return time;
    }
}

