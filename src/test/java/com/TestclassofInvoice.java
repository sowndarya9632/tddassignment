package com;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TestclassofInvoice {

	@Test
	public void testFareForNormalJourney() {
		// Given: A journey of 10 kilometers and 15 minutes
		double distance = 10.0;
		double time = 15.0;

		// When: Calculating the fare
		double totalFare = InvoiceGenerator.generateFare(distance, time);

		// Then: The total fare should be calculated as (10 * 10) + (15 * 1) = 100 + 15
		// = 115
		assertEquals(115.0, totalFare);
	}

	@Test
	public void testFareForJourneyWithMinimumFare() {
		// Given: A journey of 0.1 kilometers and 2 minutes
		double distance = 0.1;
		double time = 2.0;

		// When: Calculating the fare
		double totalFare = InvoiceGenerator.generateFare(distance, time);

		// Then: The total fare should be adjusted to the minimum fare of ₹5
		assertEquals(5.0, totalFare);
	}

	@Test
	public void testFareForJourneyWithZeroDistance() {
		// Given: A journey with zero distance and 10 minutes
		double distance = 0.0;
		double time = 10.0;

		// When: Calculating the fare
		double totalFare = InvoiceGenerator.generateFare(distance, time);

		// Then: The fare should be ₹10 (0 km * ₹10 + 10 minutes * ₹1)
		assertEquals(10.0, totalFare);
	}

	@Test
	public void testFareForJourneyWithZeroTime() {
		// Given: A journey with 5 kilometers and zero time
		double distance = 5.0;
		double time = 0.0;

		// When: Calculating the fare
		double totalFare = InvoiceGenerator.generateFare(distance, time);

		// Then: The fare should be ₹50 (5 km * ₹10 + 0 minutes * ₹1)
		assertEquals(50.0, totalFare);
	}

	@Test
	public void testFareForJourneyWithExactMinimumFare() {
		// Given: A journey with 0.3 kilometers and 2 minutes
		double distance = 0.3;
		double time = 2.0;

		// When: Calculating the fare
		double totalFare = InvoiceGenerator.generateFare(distance, time);

		// Then: The fare should be ₹5 (as it should round up to minimum fare)
		assertEquals(5.0, totalFare);
	}
}
