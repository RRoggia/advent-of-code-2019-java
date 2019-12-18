package rroggia.github.io.day2;

public class AddOpcode extends Opcode {

	private int firstIndexPosition;
	private int secondIndexPosition;
	private int storeIndexPosition;

	public AddOpcode(int firstIndexPosition, int secondIndexPosition, int storeIndexPosition) {
		super("1," + firstIndexPosition + "," + secondIndexPosition + "," + storeIndexPosition);

		this.firstIndexPosition = firstIndexPosition;
		this.secondIndexPosition = secondIndexPosition;
		this.storeIndexPosition = storeIndexPosition;
	}

	@Override
	protected String[] resolveOpcode(String[] opcodes) {
		opcodes[storeIndexPosition] = String.valueOf(
				Integer.parseInt(opcodes[firstIndexPosition]) + Integer.parseInt(opcodes[secondIndexPosition]));
		return opcodes;
	}

}
