package com.laioffer.ood.parking_lot;

import java.util.*;

class Level {
	private final List<ParkingSpot> spots;

	Level(int numberOfSpots) {
		List<ParkingSpot> spotsList = new ArrayList<ParkingSpot>();
		int i = 0;
		for (; i < numberOfSpots / 2; i++) {
			spotsList.add(new ParkingSpot(VehicleSize.Compact));
		}
		for (; i < numberOfSpots; i++) {
			spotsList.add(new ParkingSpot(VehicleSize.Large));
		}
		// what if we want to enforce the semantic that the layout is fixed and will
		// never change
		spots = Collections.unmodifiableList(spotsList);
	}

	boolean hasSpot(Vehicle vehicle) {
		for (ParkingSpot spot : spots) {
			if (spot.fit(vehicle)) {
				return true;
			}
		}
		return false;
	}

	boolean park(Vehicle vehicle) {
		for (ParkingSpot spot : spots) {
			if (spot.fit(vehicle)) {
				spot.park(vehicle);
				return true;
			}
		}
		return false;
	}

	boolean leave(Vehicle vehicle) {
		for (ParkingSpot spot : spots) {
			if (spot.getVehicle() == vehicle) {
				spot.leave();
				return true;
			}
		}
		return false;
	}
}
