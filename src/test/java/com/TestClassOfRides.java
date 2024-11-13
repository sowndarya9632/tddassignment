package com;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

public class TestClassOfRides {

    @Test
    public void testInvoiceForMultipleRides() {
        // Given: A list of multiple rides with different distances and times
        Ride ride1 = new Ride(10.0, 15.0); // 10 km, 15 minutes
        Ride ride2 = new Ride(5.0, 10.0);  // 5 km, 10 minutes
        Ride ride3 = new Ride(0.1, 2.0);   // 0.1 km, 2 minutes
        Ride ride4 = new Ride(2.0, 5.0);   // 2 km, 5 minutes
        
        // List of all rides
        List<Ride> rides = Arrays.asList(ride1, ride2, ride3, ride4);

        // When: Calculating the invoice for all rides
        Invoice invoice = InvoiceGenerator.calculateInvoice(rides);

        // Then: The total rides, total fare, and average fare should be as expected
        assertEquals(4, invoice.getTotalRides());  // 4 rides
        assertEquals(205.0, invoice.getTotalFare(), 0.01);  // Total fare: ₹205
        assertEquals(205.0 / 4, invoice.getAverageFarePerRide(), 0.01);  // Average fare: ₹51.25
    }

    @Test
    public void testInvoiceForMultipleRidesWithMinimumFare() {
        // Given: A list of multiple rides where all fares should be adjusted to the minimum fare
        Ride ride1 = new Ride(0.1, 2.0); // 0.1 km, 2 minutes
        Ride ride2 = new Ride(0.2, 3.0); // 0.2 km, 3 minutes
        
        // List of all rides
        List<Ride> rides = Arrays.asList(ride1, ride2);

        // When: Calculating the invoice for all rides
        Invoice invoice = InvoiceGenerator.calculateInvoice(rides);

        // Then: The total rides, total fare, and average fare should be as expected
        assertEquals(2, invoice.getTotalRides());  // 2 rides
        assertEquals(10.0, invoice.getTotalFare(), 0.01);  // Total fare: ₹10 (both adjusted to ₹5)
        assertEquals(10.0 / 2, invoice.getAverageFarePerRide(), 0.01);  // Average fare: ₹5
    }

    @Test
    public void testInvoiceForEmptyRideList() {
        // Given: An empty list of rides
        List<Ride> rides = Arrays.asList();

        // When: Calculating the invoice for no rides
        Invoice invoice = InvoiceGenerator.calculateInvoice(rides);

        // Then: The total rides should be 0, total fare should be 0, and average fare should be 0
        assertEquals(0, invoice.getTotalRides());  // 0 rides
        assertEquals(0.0, invoice.getTotalFare(), 0.01);  // Total fare: ₹0
        assertEquals(0.0, invoice.getAverageFarePerRide(), 0.01);  // Average fare: ₹0
    }
}
