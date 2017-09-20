package ood2.laioffer.com;

import java.util.*;

public class Level {
	private final List<ParkingSpot> spots;

	public Level(int numberOfSpots) {
		List<ParkingSpot> spotsList = new ArrayList<>();
		int i = 0;
		for (; i < numberOfSpots / 2; i++) {
			spotsList.add(new ParkingSpot(VehicleSize.Compact));
		}
		for (; i < numberOfSpots; i++) {
			spotsList.add(new ParkingSpot(VehicleSize.Large));
		}
		
	}
}
