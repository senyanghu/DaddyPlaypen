package ood2.laioffer.com;

public class Vehicle {
	private VehicleSize size;
	private String plateID;
	private String VIN;
	private String color;
	private int year;
	private String make;

	public VehicleSize getSize() {
		return size;
	}

	public String getPlateID() {
		return plateID;
	}

	public String getVIN() {
		return VIN;
	}

	public void setVIN(String VIN) {
		this.VIN = VIN;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}
}
