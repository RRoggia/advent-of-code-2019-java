package rroggia.github.io.day2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import rroggia.github.io.day2.opcode.Opcode;

public class OpcodeReaderTest {

	private static final String ORIGINAL_OPCODE = "1,9,10,3,2,3,11,0,99,30,40,50";
	private static final String FIRST_OPCODE_RESOLVED = "1,9,10,70,2,3,11,0,99,30,40,50";
	private static final String ALL_OPCODES_RESOLVED = "3500,9,10,70,2,3,11,0,99,30,40,50";

	@Test
	public void readOpcode() {
		var opcodeReader = new OpcodeRunner(ORIGINAL_OPCODE);
		Opcode opcode = opcodeReader.getNextOpcode();
		assertEquals("1,9,10,3", opcode.toString());
	}

	@Test
	public void readFollowingOpcode() {
		var opcodeReader = new OpcodeRunner(ORIGINAL_OPCODE);
		opcodeReader.resolveNextOpcode();
		Opcode opcode = opcodeReader.getNextOpcode();
		assertEquals("2,3,11,0", opcode.toString());
	}

	@Test
	public void readUntilHalt() {
		var opcodeReader = new OpcodeRunner(ORIGINAL_OPCODE);
		opcodeReader.resolveNextOpcode();
		opcodeReader.resolveNextOpcode();
		var opcode = opcodeReader.getNextOpcode();
		assertEquals("99", opcode.toString());
	}

	@Test
	public void resolveAddOpcode() {
		var opcodeReader = new OpcodeRunner(ORIGINAL_OPCODE);
		opcodeReader.resolveNextOpcode();
		assertEquals(FIRST_OPCODE_RESOLVED, opcodeReader.getOpcodeCurrentState());
	}

	@Test
	public void resolveMultiplyOpcode() {
		var opcodeReader = new OpcodeRunner(ORIGINAL_OPCODE);
		opcodeReader.resolveNextOpcode();
		opcodeReader.resolveNextOpcode();
		assertEquals(ALL_OPCODES_RESOLVED, opcodeReader.getOpcodeCurrentState());
	}

	@Test
	public void resolveHaltOpcode() {
		var opcodeReader = new OpcodeRunner(ORIGINAL_OPCODE);
		opcodeReader.resolveNextOpcode();
		opcodeReader.resolveNextOpcode();
		opcodeReader.resolveNextOpcode();
		assertEquals(ALL_OPCODES_RESOLVED, opcodeReader.getOpcodeCurrentState());
	}

	@Test
	public void resolveAllOpcodes() {
		var opcodeReader = new OpcodeRunner(ORIGINAL_OPCODE);
		opcodeReader.resolveAllOpcodes();
		assertEquals(ALL_OPCODES_RESOLVED, opcodeReader.getOpcodeCurrentState());
	}

}
