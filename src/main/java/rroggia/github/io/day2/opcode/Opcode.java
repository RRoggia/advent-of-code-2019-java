package rroggia.github.io.day2.opcode;

import rroggia.github.io.day2.Operation;

public abstract class Opcode {
	private String opcode;

	public Opcode(String opcode) {
		this.opcode = opcode;
	}

	@Override
	public String toString() {
		return this.opcode;
	}

	public abstract String[] resolve(String[] opcodes);

	public abstract Operation getOperation();

}
