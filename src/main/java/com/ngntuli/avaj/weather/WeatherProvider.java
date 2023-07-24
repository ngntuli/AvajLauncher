package com.ngntuli.avaj.weather;

public final class WeatherProvider {
	private final static WeatherProvider instance = new WeatherProvider();
	private final static String[] weather = { "RAIN", "FOG", "SUN", "SNOW" };

	private WeatherProvider() {

	}

	public static WeatherProvider getInstance() {
		return instance;
	}

	public static String[] getWeather() {
		return weather;
	}
}
