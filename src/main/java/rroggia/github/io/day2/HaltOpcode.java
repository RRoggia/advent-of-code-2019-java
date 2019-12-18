package rroggia.github.io.day2;

public class HaltOpcode extends Opcode {

	public HaltOpcode() {
		super("99");
	}

	@Override
	protected String[] resolveOpcode(String[] opcodes) {
		return opcodes;
	}

	@Override
	protected String getOperation() {
		return "99";
	}

}
