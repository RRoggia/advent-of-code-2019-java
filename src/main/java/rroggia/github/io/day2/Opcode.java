package rroggia.github.io.day2;

public abstract class Opcode {
	private String opcode;

	public Opcode(String opcode) {
		this.opcode = opcode;
	}

	@Override
	public String toString() {
		return this.opcode;
	}

	protected abstract String[] resolveOpcode(String[] opcodes);

	protected abstract String getOperation();
}
