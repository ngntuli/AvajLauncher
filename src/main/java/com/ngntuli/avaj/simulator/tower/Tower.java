package com.ngntuli.avaj.simulator.tower;

import java.util.ArrayList;
import java.util.List;

import com.ngntuli.avaj.simulator.Flyable;
import com.ngntuli.avaj.simulator.vehicles.Aircraft;

public class Tower {
	private List<Flyable> observers = new ArrayList<>();

	public void register(Flyable flyable) {
		if (observers.add(flyable)) {
		} else {
			throw new IllegalArgumentException();
		}
	}

	public void unRegister(Flyable flyable) {
		observers.remove(flyable);
	}

	public List<Flyable> getObservers() {
		return observers;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Tower [observers=");
		builder.append(observers);
		builder.append("]");
		return builder.toString();
	}

}
