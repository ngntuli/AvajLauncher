package com.ngntuli.avaj;

import java.util.List;

import com.ngntuli.avaj.simulator.Flyable;
import com.ngntuli.avaj.simulator.tower.WeatherTower;
import com.ngntuli.avaj.simulator.vehicles.Aircraft;
import com.ngntuli.avaj.simulator.vehicles.AircraftFactory;
import com.ngntuli.avaj.utilities.IOUtil;

public class Avaj {

	public static void main(String[] args) {

		createAircraft(args);
	}

	private static void createAircraft(String[] args) {
		if (args.length == 1) {
			WeatherTower weatherTower = new WeatherTower();
			Flyable flyable;

			System.out.println("\nReading file ...");
			String line = IOUtil.read(args[0]);

			System.out.println("\nCreate Aircraft ...");

			String[] lines = line.split("\n");
			for (int i = 1; i < lines.length; i++) {

				long id = Aircraft.getIdCounter();
				String[] airCraft = lines[i].split("\s");
				String name = airCraft[1];
				int longitude = Integer.parseInt(airCraft[2]);
				int latitude = Integer.parseInt(airCraft[3]);
				int height = Integer.parseInt(airCraft[4]);

				String type = airCraft[0];
				if (type.equals("Helicopter")) {
					flyable = AircraftFactory.createAircraft("Helicopter", name, longitude, latitude, height);

					flyable.registerTower(weatherTower);

					weatherTower.register(flyable);

					System.out
							.println("Tower says: " + type + "#" + name + "(" + id + ") registered to weather tower.");
				} else if (type.equals("JetPlane")) {
					flyable = AircraftFactory.createAircraft("JetPlane", name, longitude, latitude, height);

					flyable.registerTower(weatherTower);

					weatherTower.register(flyable);

					System.out
							.println("Tower says: " + type + "#" + name + "(" + id + ") registered to weather tower.");
				} else {
					flyable = AircraftFactory.createAircraft("Baloon", name, longitude, latitude, height);

					flyable.registerTower(weatherTower);

					weatherTower.register(flyable);

					System.out
							.println("Tower says: " + type + "#" + name + "(" + id + ") registered to weather tower.");
				}
			}
			List<Flyable> flyables = weatherTower.getObservers();
			int len = Integer.parseInt(lines[0]);

			int i = 0;
			while (i < len) {
				System.out.println("Simulation : " + (i + 1) + " -".repeat(26));
				for (int j = 0; j < flyables.size(); j++) {
					flyables.get(j).updateConditions();
				}
				i++;
			}

		} else {
			System.err.println("Error: enter file name \"scenario.txt\" in argument");
		}
	}

}
