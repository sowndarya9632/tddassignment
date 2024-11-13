package com;

public class Ride {
    
    private double distance; // in kilometers
    private double time;     // in minutes

    // Constructor
    public Ride(double distance, double time) {
        this.distance = distance;
        this.time = time;
    }

    // Getters
    public double getDistance() {
        return distance;
    }

    public double getTime() {
        return time;
    }
}
