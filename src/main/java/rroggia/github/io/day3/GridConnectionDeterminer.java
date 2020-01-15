package rroggia.github.io.day3;

import java.util.HashSet;
import java.util.Set;

public class GridConnectionDeterminer {

	private static final GridConnectionDeterminer INSTANCE = new GridConnectionDeterminer();

	private static final char UP = 'U';
	private static final char DOWN = 'D';
	private static final char RIGHT = 'R';
	private static final char LEFT = 'L';

	private GridConnectionDeterminer() {
		// override public constructor created by default from java
	}

	public static GridConnectionDeterminer getInstance() {
		return INSTANCE;
	}

	public Set<String> determineConnections(String wireTraces) {
		var connectionsInTheGrid = new HashSet<String>();

		String[] traces = wireTraces.split(",");

		int axisX = 0;
		int axisY = 0;

		connectionsInTheGrid.add(createKey(axisX, axisY));

		if (!(traces[0].isBlank() || traces[0].isEmpty())) {
			for (String trace : traces) {
				var direction = trace.charAt(0);
				var moviment = Integer.parseInt(trace.substring(1, trace.length()));

				switch (direction) {
				case UP:
					for (int i = 1; i <= moviment; i++) {
						axisX++;
						connectionsInTheGrid.add(createKey(axisX, axisY));
					}
					break;
				case DOWN:
					for (int i = 1; i <= moviment; i++) {
						axisX--;
						connectionsInTheGrid.add(createKey(axisX, axisY));
					}
					break;
				case RIGHT:
					for (int i = 1; i <= moviment; i++) {
						axisY++;
						connectionsInTheGrid.add(createKey(axisX, axisY));
					}
					break;
				case LEFT:
					for (int i = 1; i <= moviment; i++) {
						axisY--;
						connectionsInTheGrid.add(createKey(axisX, axisY));
					}
					break;
				default:
					throw new RuntimeException("input or split is not right.");
				}
			}
		}

		return connectionsInTheGrid;
	}

	private String createKey(int axisX, int axisY) {
		return axisX + "," + axisY;
	}
}
