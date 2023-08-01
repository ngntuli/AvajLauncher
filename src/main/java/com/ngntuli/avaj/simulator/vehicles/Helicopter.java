package com.ngntuli.avaj.simulator.vehicles;

import java.util.Arrays;

import com.ngntuli.avaj.simulator.Flyable;
import com.ngntuli.avaj.simulator.tower.WeatherTower;

public class Helicopter extends Aircraft implements Flyable {
	private String type;
	private WeatherTower weatherTower;

	public Helicopter(String type, String name, Coordinates coordinates) {
		this.id = Aircraft.getIdCounter();
		this.type = type;
		this.name = name;
		this.coordinates = coordinates;
		Aircraft.nextId();
	}

	@Override
	public void updateConditions() {
		int longitude = coordinates.getLongitude();
		int latitude = coordinates.getLatitude();
		int height = coordinates.getHeight();
		int increases = 0;
		int decreases = 0;

		weatherTower.changeWeather();
		String weather = weatherTower.getWeather();
		if (weather.equals("SUN")) {
			increases = 10;
			coordinates.setLongitude(longitude + increases);

			height = height + 2;
			setHeight(height, 0);
		} else if (weather.equals("RAIN")) {
			increases = 5;
			coordinates.setLongitude(longitude + increases);
			System.out.println(type + "#" + name + "(" + id + "): " + msg[1]);
		} else if (weather.equals("FOG")) {
			increases = 1;
			coordinates.setLongitude(longitude + increases);
			System.out.println(type + "#" + name + "(" + id + "): " + msg[2]);
		} else {
			height = height - 12;
			setHeight(height, 3);
		}
	}

	@Override
	public void registerTower(WeatherTower weatherTower) {
		this.weatherTower = weatherTower;
	}

	@Override
	public long getId() {
		return id;
	}

	@Override
	protected void setHeight(int height, int msgIndex) {
		if (isLanding(height)) {
			System.out.println(type + "#" + name + "(" + id + ") landing.\n");

			weatherTower.unRegister(this);
			System.out.println("Tower says: " + type + "#" + name + "(" + id + ") unregistered from weather tower.\n");
		} else if (height > 100) {
			height = 100;
			coordinates.setHeight(height);
			System.out.println(type + "#" + name + "(" + id + "): " + msg[msgIndex]);
		} else {
			coordinates.setHeight(height);
			System.out.println(type + "#" + name + "(" + id + "): " + msg[msgIndex]);
		}
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Helicopter [type=");
		builder.append(type);
		builder.append(", id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", coordinates=");
		builder.append(coordinates);
		builder.append(", msg=");
		builder.append(Arrays.toString(msg));
		builder.append("]");
		return builder.toString();
	}

}
