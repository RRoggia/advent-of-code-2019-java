package rroggia.github.io.day2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class OpcodeReaderTest {

	@Test
	public void readOpcode() {
		var opcodeReader = new OpcodeReader("1,9,10,3,2,3,11,0,99,30,40,50");
		Opcode opcode = opcodeReader.getNextOpcode();
		assertEquals("1,9,10,3", opcode.toString());
	}

	@Test
	public void readFollowingOpcode() {
		var opcodeReader = new OpcodeReader("1,9,10,3,2,3,11,0,99,30,40,50");
		opcodeReader.getNextOpcode();
		Opcode opcode = opcodeReader.getNextOpcode();
		assertEquals("2,3,11,0", opcode.toString());
	}

	@Test
	public void readUntilHalt() {
		var opcodeReader = new OpcodeReader("1,9,10,3,2,3,11,0,99,30,40,50");
		opcodeReader.getNextOpcode();
		opcodeReader.getNextOpcode();
		var opcode = opcodeReader.getNextOpcode();
		assertEquals("99", opcode.toString());
	}

	@Test
	public void resolveAddOpcode() {
		var opcodeReader = new OpcodeReader("1,9,10,3,2,3,11,0,99,30,40,50");
		opcodeReader.resolveNextOpcode();
		assertEquals("1,9,10,70,2,3,11,0,99,30,40,50", opcodeReader.getOpcodeCurrentState());
	}

	@Test
	public void resolveMultiplyOpcode() {
		var opcodeReader = new OpcodeReader("1,9,10,3,2,3,11,0,99,30,40,50");
		opcodeReader.resolveNextOpcode();
		opcodeReader.resolveNextOpcode();
		assertEquals("3500,9,10,70,2,3,11,0,99,30,40,50", opcodeReader.getOpcodeCurrentState());
	}

	@Test
	public void resolveHaltOpcode() {
		var opcodeReader = new OpcodeReader("1,9,10,3,2,3,11,0,99,30,40,50");
		opcodeReader.resolveNextOpcode();
		opcodeReader.resolveNextOpcode();
		opcodeReader.resolveNextOpcode();
		assertEquals("3500,9,10,70,2,3,11,0,99,30,40,50", opcodeReader.getOpcodeCurrentState());
	}

}
