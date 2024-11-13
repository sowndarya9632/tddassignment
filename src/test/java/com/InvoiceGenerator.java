package com;

import java.util.List;

public class InvoiceGenerator {

	// Constants representing pricing rules
	private static final double COST_PER_KM = 10.0; // ₹10 per kilometer
	private static final double COST_PER_MINUTE = 1.0; // ₹1 per minute
	private static final double MINIMUM_FARE = 5.0; // Minimum fare ₹5
    
	private RideRepository rideRepository;

    // Constructor
    public InvoiceGenerator(RideRepository rideRepository) {
        this.rideRepository = rideRepository;
    }
	

	public static double generateFare(double distance, double time) {
		// Calculate the fare for the distance and time
		double distanceFare = distance * COST_PER_KM;
		double timeFare = time * COST_PER_MINUTE;

		// Total fare includes the distance fare and time fare
		double totalFare = distanceFare + timeFare;

		// If the total fare is less than the minimum fare, use the minimum fare
		if (totalFare < MINIMUM_FARE) {
			totalFare = MINIMUM_FARE;
		}

		return totalFare;
	}

	public static double calculateTotalFare(List<Ride> rides) {
		double totalFare = 0.0;

		// Loop through each ride and calculate the total fare
		for (Ride ride : rides) {
			totalFare += generateFare(ride.getDistance(), ride.getTime());
		}

		return totalFare;
	}
	public static Invoice calculateInvoice(List<Ride> rides) {
        double totalFare = 0.0;
        int totalRides = rides.size();

        // Loop through each ride and calculate the total fare
        for (Ride ride : rides) {
            totalFare += generateFare(ride.getDistance(), ride.getTime());
        }

        // Return an Invoice object containing the details
        return new Invoice(totalRides, totalFare);
    }
	public Invoice generateInvoiceForUser(String userId) {
        
		// Fetch the rides for the given user
        List<Rides> rides = rideRepository.getRidesByUserId(userId);

        // If no rides, return an empty invoice
        if (rides.isEmpty()) {
            return new Invoice(0, 0.0);
        }

        double totalFare = 0.0;
        int totalRides = rides.size();

        // Calculate the total fare for all rides
        for (Rides ride : rides) {
            totalFare += generateFare(ride.getDistance(), ride.getTime());
        }

        // Return the invoice with the calculated details
        return new Invoice(totalRides, totalFare);
    }
}
