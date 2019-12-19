package rroggia.github.io.day2.opcode;

import rroggia.github.io.day2.Operation;

public class HaltOpcode extends Opcode {

	public HaltOpcode() {
		super("99");
	}

	@Override
	public String[] resolve(String[] opcodes) {
		return opcodes;
	}

	@Override
	public Operation getOperation() {
		return Operation.HALT;
	}

}
