package com;

import java.util.List;
import java.util.ArrayList;

public class RideRepository {

    // Simulating a data store (e.g., in-memory database)
    private static final List<Rides> ridesDatabase = new ArrayList<>();

    static {
        // Sample data
        ridesDatabase.add(new Rides("U001", 10.0, 15.0)); // User U001, 10 km, 15 minutes
        ridesDatabase.add(new Rides("U001", 5.0, 10.0));  // User U001, 5 km, 10 minutes
        ridesDatabase.add(new Rides("U002", 0.1, 2.0));   // User U002, 0.1 km, 2 minutes
        ridesDatabase.add(new Rides("U001", 2.0, 5.0));   // User U001, 2 km, 5 minutes
        ridesDatabase.add(new Rides("U003", 3.0, 7.0));   // User U003, 3 km, 7 minutes
    }

    /**
     * Retrieves a list of rides for a specific user ID.
     * 
     * @param userId The ID of the user
     * @return A list of rides associated with the user ID
     */
    public List<Rides> getRidesByUserId(String userId) {
        List<Rides> userRides = new ArrayList<>();
        for (Rides ride : ridesDatabase) {
            if (ride.getUserId().equals(userId)) {
                userRides.add(ride);
            }
        }
        return userRides;
    }
}

