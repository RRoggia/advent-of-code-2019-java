package rroggia.github.io.day2;

public class OpcodeReader {

	private String opcodes;
	private int lastOpcodeIndex = 0;

	public OpcodeReader(String opcodes) {
		this.opcodes = opcodes;
	}

	public Opcode getNextOpcode() {
		String[] splitedOpcodes = opcodes.split(",");
		String opcode = "";

		String operation = splitedOpcodes[lastOpcodeIndex];
		if (OperationCode.ADD.getCode().equals(operation) || OperationCode.MULTIPLIER.getCode().equals(operation)) {
			opcode = splitedOpcodes[lastOpcodeIndex] + "," + splitedOpcodes[lastOpcodeIndex + 1] + ","
					+ splitedOpcodes[lastOpcodeIndex + 2] + "," + splitedOpcodes[lastOpcodeIndex + 3];
			lastOpcodeIndex += 4;
		} else if (OperationCode.HALT.getCode().equals(operation)) {
			opcode = splitedOpcodes[0];
			lastOpcodeIndex += 1;
		}

		return new Opcode(opcode);
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

}
