package rroggia.github.io.day2;

public class MultiplierOpcode extends ChangeMemoryBasedOnTwoInputsOpcode {

	public MultiplierOpcode(int firstIndexPosition, int secondIndexPosition, int storeIndexPosition) {
		super(2, firstIndexPosition, secondIndexPosition, storeIndexPosition);
	}

	@Override
	protected int applyConcreteOperation(String[] opcodes) {
		return Integer.parseInt(opcodes[firstIndexPosition]) * Integer.parseInt(opcodes[secondIndexPosition]);
	}

	@Override
	protected String getOperation() {
		return "99";
	}

}
