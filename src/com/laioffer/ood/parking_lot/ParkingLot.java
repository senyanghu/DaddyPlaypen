package com.laioffer.ood.parking_lot;

public class ParkingLot {
	private final Level[] levels;

	public ParkingLot(int numberLevels, int numberSpotsPerLevel) {
		levels = new Level[numberLevels];
		for (int i = 0; i < numberLevels; i++) {
			levels[i] = new Level(numberSpotsPerLevel);
		}
	}

	public boolean hasSpot(Vehicle vehicle) {
		for (Level level : levels) {
			if (level.hasSpot(vehicle)) {
				return true;
			}
		}
		return false;
	}

	public boolean park(Vehicle vehicle) {
		for (Level level : levels) {
			if (level.park(vehicle)) {
				return true;
			}
		}
		return false;
	}

	public boolean leave(Vehicle vehicle) {
		for (Level level : levels) {
			if (level.leave(vehicle)) {
				return true;
			}
		}
		return false;
	}
}
