package com.ngntuli.avaj.simulator.vehicles;

public abstract class Aircraft {
	private static long idCounter = 1;
	protected long id;

	protected String name;
	protected Coordinates coordinates;
	protected String[] msg = { "Let's enjoy the good weather and take some pics.\n",
			"It's raining. Better watch out for lightings.\n", "It's foggy.\n", "OMG! Winter is coming!\n" };

	public static long getIdCounter() {
		return idCounter;
	}

	protected static void nextId() {
		idCounter++;
	}

	public abstract long getId();

}
