package rroggia.github.io.day1;

import java.util.Arrays;
import java.util.List;

public class FuelRequirement {
	private List<Module> modules;

	public FuelRequirement(Module... module) {
		modules = Arrays.asList(module);
	}

	public int calculateFuelRequirement() {
		int fuelRequirement = 0;
		for (var module : modules) {
			fuelRequirement += module.determineFuelRequiredToLaunch();
		}
		return fuelRequirement;
	}

}
