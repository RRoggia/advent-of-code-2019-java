package rroggia.github.io.day1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class FuelRequirementCalculatorTest {

	@Test
	public void calculateFuelForOneModule() {
		var calculator = new FuelRequirementCalculator(new Module(12));
		assertEquals(2, calculator.calculateFuelRequirements());
	}

	@Test
	public void calculateFuelForMoreThanOneModule() {
		var calculator = new FuelRequirementCalculator(new Module(12), new Module(14), new Module(1969),
				new Module(100756));

		assertEquals(34241, calculator.calculateFuelRequirements());
	}

}
