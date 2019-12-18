package rroggia.github.io.day2;

public class MultiplierOpcode extends Opcode {

	private int firstIndexPosition;
	private int secondIndexPosition;
	private int storeIndexPosition;

	public MultiplierOpcode(int firstIndexPosition, int secondIndexPosition, int storeIndexPosition) {
		super("2," + firstIndexPosition + "," + secondIndexPosition + "," + storeIndexPosition);

		this.firstIndexPosition = firstIndexPosition;
		this.secondIndexPosition = secondIndexPosition;
		this.storeIndexPosition = storeIndexPosition;
	}

	@Override
	protected String[] resolveOpcode(String[] opcodes) {
		opcodes[storeIndexPosition] = String.valueOf(
				Integer.parseInt(opcodes[firstIndexPosition]) * Integer.parseInt(opcodes[secondIndexPosition]));
		return opcodes;
	}

}
