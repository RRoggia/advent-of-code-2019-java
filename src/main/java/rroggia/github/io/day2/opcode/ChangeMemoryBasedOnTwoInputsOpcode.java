package rroggia.github.io.day2.opcode;

public abstract class ChangeMemoryBasedOnTwoInputsOpcode extends Opcode {

	protected int operation;
	protected int firstIndexPosition;
	protected int secondIndexPosition;
	protected int storeIndexPosition;

	public ChangeMemoryBasedOnTwoInputsOpcode(int operation, int firstIndexPosition, int secondIndexPosition,
			int storeIndexPosition) {
		super(operation + "," + firstIndexPosition + "," + secondIndexPosition + "," + storeIndexPosition);

		this.operation = operation;
		this.firstIndexPosition = firstIndexPosition;
		this.secondIndexPosition = secondIndexPosition;
		this.storeIndexPosition = storeIndexPosition;
	}

	@Override
	public String[] resolve(String[] opcodes) {
		opcodes[storeIndexPosition] = String.valueOf(applyConcreteOperation(opcodes));
		return opcodes;
	}

	public abstract int applyConcreteOperation(String[] opcodes);
}
