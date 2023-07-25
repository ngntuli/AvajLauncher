package com.ngntuli.avaj.weather;

public final class WeatherProvider {
	private final static WeatherProvider instance = new WeatherProvider();
	private final static String[] weather = { "RAIN", "FOG", "SUN", "SNOW" };

	private WeatherProvider() {

	}

	public static WeatherProvider getInstance() {
		return instance;
	}

	public static String getWeather() {
		int i = 0;
		int len = 1;
		while (i < len) {
			double randD = Math.random() * 10;
			int randI = (int) randD;
			if (randI < 4) {
				return weather[randI];
			} else {
				len++;
			}
			i++;
		}
		return null;
	}
}
