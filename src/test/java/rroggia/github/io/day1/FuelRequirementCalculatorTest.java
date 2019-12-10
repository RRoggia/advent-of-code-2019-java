package rroggia.github.io.day1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class FuelRequirementCalculatorTest {

	@Test
	public void calculateFuelForOneModule() {
		var calculator = new FuelRequirementCalculator(new Module(12));
		assertEquals(2, calculator.calculateFuelRequirements());
	}

}
