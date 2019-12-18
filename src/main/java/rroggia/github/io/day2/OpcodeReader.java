package rroggia.github.io.day2;

public class OpcodeReader {

	private int lastOpcodeIndex = 0;
	private String[] opcodes;

	public OpcodeReader(String opcodes) {
		this.opcodes = opcodes.split(",");
	}

	public Opcode getNextOpcode() {
		String nextOpcode = "";

		String operation = opcodes[lastOpcodeIndex];
		if (OperationCode.ADD.getCode().equals(operation) || OperationCode.MULTIPLIER.getCode().equals(operation)) {
			nextOpcode = opcodes[lastOpcodeIndex] + "," + opcodes[lastOpcodeIndex + 1] + ","
					+ opcodes[lastOpcodeIndex + 2] + "," + opcodes[lastOpcodeIndex + 3];
			lastOpcodeIndex += 4;
		} else if (OperationCode.HALT.getCode().equals(operation)) {
			nextOpcode = opcodes[lastOpcodeIndex];
			lastOpcodeIndex += 1;
		}

		return new Opcode(nextOpcode);
	}

	private enum OperationCode {
		ADD("1"), MULTIPLIER("2"), HALT("99");

		private final String code;

		OperationCode(String code) {
			this.code = code;
		}

		public String getCode() {
			return this.code;
		}
	}

	public void resolveNextOpcode() {
		Opcode nextOpcode = this.getNextOpcode();
		var opcodes = nextOpcode.toString().split(",");

		String operation = opcodes[0];
		if (OperationCode.ADD.getCode().equals(operation)) {
			this.opcodes[Integer.parseInt(opcodes[3])] = String
					.valueOf(Integer.parseInt(this.opcodes[Integer.parseInt(opcodes[1])])
							+ Integer.parseInt(this.opcodes[Integer.parseInt(opcodes[2])]));
		}

	}

	public String getOpcodeCurrentState() {
		String opcodeCurrentState = "";
		for (var opcode : opcodes) {
			opcodeCurrentState += opcode + ",";
		}
		return opcodeCurrentState.substring(0, opcodeCurrentState.length() - 1);
	}

}
