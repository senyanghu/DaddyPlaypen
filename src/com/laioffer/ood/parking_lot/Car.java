package com.laioffer.ood.parking_lot;

public class Car extends Vehicle {
	@Override
	public VehicleSize getSize() {
		return VehicleSize.Compact;
	}
}
