package rroggia.github.io.day1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ModuleTest {

	@Test
	public void determineFuelRequiredToLaunch() {
		int fuelRequiredToLaunch = new Module(12).determineFuelRequiredToLaunch();
		assertEquals(2, fuelRequiredToLaunch);

		assertEquals(654, new Module(1969).determineFuelRequiredToLaunch());
		assertEquals(33583, new Module(100756).determineFuelRequiredToLaunch());
	}

	@Test
	public void roundingDown() {
		int fuelRequiredToLaunch = new Module(14).determineFuelRequiredToLaunch();
		assertEquals(2, fuelRequiredToLaunch);
	}
}
