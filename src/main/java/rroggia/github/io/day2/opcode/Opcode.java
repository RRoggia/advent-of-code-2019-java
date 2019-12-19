package rroggia.github.io.day2.opcode;

import rroggia.github.io.day2.Operation;

public abstract class Opcode {

	public abstract String[] resolve(String[] opcodes);

	public abstract Operation getOperation();

}
