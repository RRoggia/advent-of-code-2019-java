package rroggia.github.io.day3;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;

public class GridConnectionDeterminer {

	private static final char UP = 'U';
	private static final char DOWN = 'D';
	private static final char RIGHT = 'R';
	private static final char LEFT = 'L';

	private Set<String> gridConnections;
	private int axisX;
	private int axisY;

	public Set<String> determineConnections(String wireTraces) {

		String[] traces = wireTraces.split(",");

		gridConnections = new HashSet<>();
		axisX = 0;
		axisY = 0;

		gridConnections.add(createKey(axisX, axisY));

		if (hasConnectionsToDetemine(traces)) {
			for (String trace : traces) {
				var direction = trace.charAt(0);
				var moviment = Integer.parseInt(trace.substring(1, trace.length()));

				switch (direction) {
				case RIGHT:
					addConnectionFromAxisX(moviment, x -> ++x);
					break;
				case LEFT:
					addConnectionFromAxisX(moviment, x -> --x);
					break;
				case UP:
					addConnectionFromAxisY(moviment, y -> ++y);
					break;
				case DOWN:
					addConnectionFromAxisY(moviment, y -> --y);
					break;
				default:
					throw new RuntimeException("input or split is not right.");
				}
			}
		}
		return gridConnections;
	}

	private boolean hasConnectionsToDetemine(String[] traces) {
		return !(traces == null || traces[0].isBlank() || traces[0].isEmpty());
	}

	private String createKey(int axisX, int axisY) {
		return axisX + "," + axisY;
	}

	private void addConnectionFromAxisX(int moviment, Function<Integer, Integer> operationX) {
		addConnectionsToGrid(moviment, operationX, Function.identity());
	}

	private void addConnectionFromAxisY(int moviment, Function<Integer, Integer> operationY) {
		addConnectionsToGrid(moviment, Function.identity(), operationY);
	}

	private void addConnectionsToGrid(int moviment, Function<Integer, Integer> operationX,
			Function<Integer, Integer> operationY) {
		for (int i = 1; i <= moviment; i++) {
			axisX = operationX.apply(axisX);
			axisY = operationY.apply(axisY);
			gridConnections.add(createKey(axisX, axisY));
		}
	}
}
