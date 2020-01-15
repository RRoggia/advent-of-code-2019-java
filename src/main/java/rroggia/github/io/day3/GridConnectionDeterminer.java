package rroggia.github.io.day3;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;

public class GridConnectionDeterminer {

	private static final char UP = 'U';
	private static final char DOWN = 'D';
	private static final char RIGHT = 'R';
	private static final char LEFT = 'L';

	private static final GridConnectionDeterminer INSTANCE = new GridConnectionDeterminer();

	public static final GridConnectionDeterminer getInstance() {
		return INSTANCE;
	}
	private GridConnectionDeterminer() {
		// make it private to avoid intantiation via constructor
	}

	public Set<String> determineConnections(String wireTraces) {

		String[] traces = wireTraces.split(",");

		Set<String> gridConnections = new HashSet<>();
		int axisX = 0;
		int axisY = 0;

		gridConnections.add(createKey(axisX, axisY));

		if (hasConnectionsToDetemine(traces)) {
			for (String trace : traces) {
				var direction = trace.charAt(0);
				var moviment = Integer.parseInt(trace.substring(1, trace.length()));

				switch (direction) {
				case RIGHT:
					addConnectionFromAxisX(gridConnections, moviment, axisX, axisY, x -> ++x);
					axisX += moviment;
					break;
				case LEFT:
					addConnectionFromAxisX(gridConnections, moviment, axisX, axisY, x -> --x);
					axisX -= moviment;
					break;
				case UP:
					addConnectionFromAxisY(gridConnections, moviment, axisX, axisY, y -> ++y);
					axisY += moviment;
					break;
				case DOWN:
					addConnectionFromAxisY(gridConnections, moviment, axisX, axisY, y -> --y);
					axisY -= moviment;
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

	private void addConnectionFromAxisX(Set<String> gridConnections, int moviment, int axisX, int axisY,
			Function<Integer, Integer> operationX) {
		addConnectionsToGrid(gridConnections, moviment, axisX, axisY, operationX, Function.identity());
	}

	private void addConnectionFromAxisY(Set<String> gridConnections, int moviment, int axisX, int axisY,
			Function<Integer, Integer> operationY) {
		addConnectionsToGrid(gridConnections, moviment, axisX, axisY, Function.identity(), operationY);
	}

	private void addConnectionsToGrid(Set<String> gridConnections, int moviment, int axisX, int axisY,
			Function<Integer, Integer> operationX, Function<Integer, Integer> operationY) {
		for (int i = 1; i <= moviment; i++) {
			axisX = operationX.apply(axisX);
			axisY = operationY.apply(axisY);
			gridConnections.add(createKey(axisX, axisY));
		}
	}
}
