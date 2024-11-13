package com;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

public class TestClassOfRide {

    @Test
    public void testFareForMultipleRides() {
        // Given: A list of multiple rides with different distances and times
        Ride ride1 = new Ride(10.0, 15.0); // 10 km, 15 minutes
        Ride ride2 = new Ride(5.0, 10.0);  // 5 km, 10 minutes
        Ride ride3 = new Ride(0.1, 2.0);   // 0.1 km, 2 minutes
        Ride ride4 = new Ride(2.0, 5.0);   // 2 km, 5 minutes
        
        // List of all rides
        List<Ride> rides = Arrays.asList(ride1, ride2, ride3, ride4);

        // When: Calculating the total fare for all rides
        double totalFare = InvoiceGenerator.calculateTotalFare(rides);

        // Then: The total fare should be the sum of fares for each ride
        // Fare for ride 1: (10*10) + (15*1) = 100 + 15 = 115
        // Fare for ride 2: (5*10) + (10*1) = 50 + 10 = 60
        // Fare for ride 3: (0.1*10) + (2*1) = 1 + 2 = 3, but minimum fare = 5
        // Fare for ride 4: (2*10) + (5*1) = 20 + 5 = 25
        // Total fare = 115 + 60 + 5 + 25 = 205
        assertEquals(205.0, totalFare);
    }

    @Test
    public void testFareForMultipleRidesWithMinimumFare() {
        // Given: A list of multiple rides where all fares should be adjusted to the minimum fare
        Ride ride1 = new Ride(0.1, 2.0); // 0.1 km, 2 minutes
        Ride ride2 = new Ride(0.2, 3.0); // 0.2 km, 3 minutes
        
        // List of all rides
        List<Ride> rides = Arrays.asList(ride1, ride2);

        // When: Calculating the total fare for all rides
        double totalFare = InvoiceGenerator.calculateTotalFare(rides);

        // Then: The total fare should be 2 rides each adjusted to the minimum fare ₹5
        // Fare for each ride is ₹5, so total fare = 5 + 5 = ₹10
        assertEquals(10.0, totalFare);
    }

    @Test
    public void testFareForEmptyRideList() {
        // Given: An empty list of rides
        List<Ride> rides = Arrays.asList();

        // When: Calculating the total fare for no rides
        double totalFare = InvoiceGenerator.calculateTotalFare(rides);

        // Then: The total fare should be 0 since there are no rides
        assertEquals(0.0, totalFare);
    }
}
