package rroggia.github.io.day2;

public class OpcodeReader {

	private int lastOpcodeIndex = 0;
	private String[] opcodes;

	public OpcodeReader(String opcodes) {
		this.opcodes = opcodes.split(",");
	}

	public Opcode getNextOpcode() {

		String operation = opcodes[lastOpcodeIndex];
		if (OperationCode.ADD.getCode().equals(operation)) {
			var firstIndexPosition = Integer.parseInt(opcodes[lastOpcodeIndex + 1]);
			var secondIndexPosition = Integer.parseInt(opcodes[lastOpcodeIndex + 2]);
			var storeIndexPosition = Integer.parseInt(opcodes[lastOpcodeIndex + 3]);

			return new AddOpcode(firstIndexPosition, secondIndexPosition, storeIndexPosition);
		} else if (OperationCode.MULTIPLIER.getCode().equals(operation)) {
			var firstIndexPosition = Integer.parseInt(opcodes[lastOpcodeIndex + 1]);
			var secondIndexPosition = Integer.parseInt(opcodes[lastOpcodeIndex + 2]);
			var storeIndexPosition = Integer.parseInt(opcodes[lastOpcodeIndex + 3]);

			return new MultiplierOpcode(firstIndexPosition, secondIndexPosition, storeIndexPosition);
		} else if (OperationCode.HALT.getCode().equals(operation)) {
			return new HaltOpcode();
		}

		throw new RuntimeException("Could not identify operation.");
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
		var nextOpcode = this.getNextOpcode();

		if (!OperationCode.HALT.getCode().equals(nextOpcode.getOperation())) {
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

}
