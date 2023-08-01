package com.ngntuli.avaj.simulator;

import com.ngntuli.avaj.simulator.tower.WeatherTower;

public interface Flyable {
	void updateConditions();

	void registerTower(WeatherTower weatherTower);
}
