package rroggia.github.io.day2;

public class AddOpcode extends ChangeMemoryBasedOnTwoInputsOpcode {

	public AddOpcode(int firstIndexPosition, int secondIndexPosition, int storeIndexPosition) {
		super(1, firstIndexPosition, secondIndexPosition, storeIndexPosition);
	}

	@Override
	protected int applyConcreteOperation(String[] opcodes) {
		return Integer.parseInt(opcodes[firstIndexPosition]) + Integer.parseInt(opcodes[secondIndexPosition]);
	}

	@Override
	protected Operation getOperation() {
		return Operation.ADD;
	}

}
