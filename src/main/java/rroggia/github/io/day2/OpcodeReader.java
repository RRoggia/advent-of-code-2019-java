package rroggia.github.io.day2;

import static rroggia.github.io.day2.Operation.ADD;
import static rroggia.github.io.day2.Operation.HALT;
import static rroggia.github.io.day2.Operation.MULTIPLIER;

public class OpcodeReader {

	private int lastOpcodeIndex = 0;
	private String[] opcodes;

	public OpcodeReader(String opcodes) {
		this.opcodes = opcodes.split(",");
	}

	public Opcode getNextOpcode() {

		String operation = opcodes[lastOpcodeIndex];

		if (HALT.getCode().equals(operation)) {
			return new HaltOpcode();
		}

		var firstIndexPosition = Integer.parseInt(opcodes[lastOpcodeIndex + 1]);
		var secondIndexPosition = Integer.parseInt(opcodes[lastOpcodeIndex + 2]);
		var storeIndexPosition = Integer.parseInt(opcodes[lastOpcodeIndex + 3]);

		if (ADD.getCode().equals(operation)) {
			return new AddOpcode(firstIndexPosition, secondIndexPosition, storeIndexPosition);
		} else if (MULTIPLIER.getCode().equals(operation)) {
			return new MultiplierOpcode(firstIndexPosition, secondIndexPosition, storeIndexPosition);
		}

		throw new RuntimeException("Could not identify operation.");
	}

	public void resolveNextOpcode() {
		var nextOpcode = this.getNextOpcode();

		if (HALT != nextOpcode.getOperation()) {
			lastOpcodeIndex += 4;
		}

		nextOpcode.resolveOpcode(opcodes);
	}

	public String getOpcodeCurrentState() {
		String opcodeCurrentState = "";
		for (var opcode : opcodes) {
			opcodeCurrentState += opcode + ",";
		}
		return opcodeCurrentState.substring(0, opcodeCurrentState.length() - 1);
	}

	public void resolveAllOpcodes() {
		while (Operation.HALT != this.getNextOpcode().getOperation()) {
			resolveNextOpcode();
		}

	}

}
