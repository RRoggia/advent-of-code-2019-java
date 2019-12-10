package rroggia.github.io.day1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ModuleTest {

	@Test
	public void determineFuelRequiredToLaunch() {
		int fuelRequiredToLaunch = new Module(12).determineFuelRequiredToLaunch();
		assertEquals(2, fuelRequiredToLaunch);
	}


}
