package rroggia.github.io.day2.opcode;

import rroggia.github.io.day2.Operation;

public interface Opcode1 {

	String[] resolve(String[] opcodes);

	Operation getOperation();

}