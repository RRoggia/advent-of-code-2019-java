package rroggia.github.io.day1;

public class Module {

	private int mass;

	public Module(int mass) {
		this.mass = mass;
	}

	public int determineFuelRequiredToLaunch() {
		int divison = Math.floorDiv(mass, 3);
		return divison - 2;
	}

}
