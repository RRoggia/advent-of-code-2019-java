package rroggia.github.io.day2;

public enum OperationCode {

	ADD("1"), MULTIPLIER("2"), HALT("99");

	private final String code;

	OperationCode(String code) {
		this.code = code;
	}

	public String getCode() {
		return this.code;
	}

}
