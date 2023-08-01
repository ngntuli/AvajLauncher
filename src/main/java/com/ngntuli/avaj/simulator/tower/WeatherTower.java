package com.ngntuli.avaj.simulator.tower;

import com.ngntuli.avaj.weather.WeatherProvider;

public class WeatherTower extends Tower {

	private String currentWeather = WeatherProvider.getInstance().getWeather();

	public String getWeather() {
		return currentWeather;

	}

	public void changeWeather() {
		String weather = currentWeather;
		while (currentWeather.equals(weather)) {
			currentWeather = WeatherProvider.getInstance().getWeather();
		}
	}

}
