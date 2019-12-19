package rroggia.github.io.day2;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

public class AddOpcodeTest {

	@Test
	public void simpleAddition() {
		var add = new AddOpcode(1, 2, 2);
		String[] opcodes = { "1", "1", "2", "2" };
		String[] resolvedOpcode = add.resolve(opcodes);

		String[] expectedResult = { "1", "1", "3", "2" };
		assertArrayEquals(expectedResult, resolvedOpcode);
	}

}
