package com;

public class Invoice {

    private int totalRides;
    private double totalFare;
    private double averageFarePerRide;

    public Invoice(int totalRides, double totalFare) {
        this.totalRides = totalRides;
        this.totalFare = totalFare;
        this.averageFarePerRide = (totalRides > 0) ? totalFare / totalRides : 0.0;
    }

    public int getTotalRides() {
        return totalRides;
    }

    public double getTotalFare() {
        return totalFare;
    }

    public double getAverageFarePerRide() {
        return averageFarePerRide;
    }
}
