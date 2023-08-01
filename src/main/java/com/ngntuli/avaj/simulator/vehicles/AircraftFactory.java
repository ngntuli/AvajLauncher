package com.ngntuli.avaj.simulator.vehicles;

import com.ngntuli.avaj.simulator.Flyable;

public class AircraftFactory {
	public static Flyable createAircraft(String type, String name, int longitude, int latitude, int height) {
		Coordinates coordinates = new Coordinates(longitude, latitude, height);

		if (type.equals("Helicopter")) {
			return new Helicopter(type, name, coordinates);
		} else if (type.equals("JetPlane")) {
			return new JetPlane(type, name, coordinates);
		} else {
			return new Baloon(type, name, coordinates);
		}
	}
}
