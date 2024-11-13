package com;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

public class TestClassOfInvoice2 {

    @Test
    public void testGenerateInvoiceForUser() {
        // Given: A RideRepository with some sample rides
        RideRepository rideRepository = new RideRepository();

        // When: Creating an InvoiceGenerator with the repository
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator(rideRepository);

        // When: Generating the invoice for a user (U001)
        Invoice invoice = invoiceGenerator.generateInvoiceForUser("U001");

        // Then: The invoice should contain correct values
        assertEquals(3, invoice.getTotalRides());  // User U001 has 3 rides
        assertEquals(10.0 * 10 + 15.0 * 1 + 5.0 * 10 + 10.0 * 1 + 0.1 * 10 + 2.0 * 1, invoice.getTotalFare(), 0.01);  // Correct total fare
        assertEquals(invoice.getTotalFare() / invoice.getTotalRides(), invoice.getAverageFarePerRide(), 0.01);  // Correct average fare
    }

    @Test
    public void testGenerateInvoiceForNoRides() {
        // Given: A RideRepository with some sample rides
        RideRepository rideRepository = new RideRepository();

        // When: Creating an InvoiceGenerator with the repository
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator(rideRepository);

        // When: Generating the invoice for a user who has no rides (U003)
        Invoice invoice = invoiceGenerator.generateInvoiceForUser("U003");

        // Then: The invoice should indicate no rides and a fare of 0
        assertEquals(0, invoice.getTotalRides());  // User U003 has no rides
        assertEquals(0.0, invoice.getTotalFare(), 0.01);  // Total fare: ₹0
        assertEquals(0.0, invoice.getAverageFarePerRide(), 0.01);  // Average fare: ₹0
    }
}
