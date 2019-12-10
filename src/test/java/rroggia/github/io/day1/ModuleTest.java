package rroggia.github.io.day1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ModuleTest {

	@Test
	public void determineModuleMass() {
		int mass = new Module(12).determineMass();
		assertEquals(2, mass);
	}

}
