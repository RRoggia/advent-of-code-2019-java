package rroggia.github.io.day1;

import java.util.Arrays;
import java.util.List;

public class FuelRequirementCalculator {
	private List<Module> modules;

	public FuelRequirementCalculator(Module... module) {
		modules = Arrays.asList(module);
	}

	public int calculateFuelRequirements() {
		int fuelRequirement = 0;
		for (var module : modules) {
			fuelRequirement += module.determineFuelRequiredToLaunch();
		}
		return fuelRequirement;
	}

}
