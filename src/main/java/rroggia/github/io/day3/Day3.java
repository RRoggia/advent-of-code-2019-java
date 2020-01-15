package rroggia.github.io.day3;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Day3 {

	private static final String RESOURCES_FOLDER = "src/main/resources";
	private static final char UP = 'U';
	private static final char DOWN = 'D';
	private static final char RIGHT = 'R';
	private static final char LEFT = 'L';

	public static void main(String[] args) {

		try {
			var path = FileSystems.getDefault().getPath(RESOURCES_FOLDER, "day3.txt");
			var wireTraces = Files.readAllLines(path);

			Set<String> firstWireTracesKeys = determinePointsWireIsConnectedInTheGrid(wireTraces.get(0));
			Set<String> secondWireTracesKeys = determinePointsWireIsConnectedInTheGrid(wireTraces.get(1));
			var intersections = determineIntersections(firstWireTracesKeys, secondWireTracesKeys);
			int closestDistance = getClosestDistanceToPoint(intersections);
			System.out.println(closestDistance);

		} catch (IOException e) {
			System.out.println("Error while reading the input file;");
		}
	}

	public static Set<String> determinePointsWireIsConnectedInTheGrid(String wireTraces) {
		var connectionsInTheGrid = new HashSet<String>();

		String[] traces = wireTraces.split(",");

		int axisX = 0;
		int axisY = 0;

		connectionsInTheGrid.add(axisX + "," + axisY);

		if (!(traces[0].isBlank() || traces[0].isEmpty())) {
			for (String trace : traces) {
				var direction = trace.charAt(0);
				var moviment = Integer.parseInt(trace.substring(1, trace.length()));

				switch (direction) {
				case UP:
					for (int i = 1; i <= moviment; i++) {
						axisX++;
						connectionsInTheGrid.add(axisX + "," + axisY);
					}
					break;
				case DOWN:
					for (int i = 1; i <= moviment; i++) {
						axisX--;
						connectionsInTheGrid.add(axisX + "," + axisY);
					}
					break;
				case RIGHT:
					for (int i = 1; i <= moviment; i++) {
						axisY++;
						connectionsInTheGrid.add(axisX + "," + axisY);
					}
					break;
				case LEFT:
					for (int i = 1; i <= moviment; i++) {
						axisY--;
						connectionsInTheGrid.add(axisX + "," + axisY);
					}
					break;
				default:
					throw new RuntimeException("input or split is not right.");
				}
			}
		}

		return connectionsInTheGrid;
	}

	private static List<String> determineIntersections(Set<String> firstWireTracesKeys,
			Set<String> secondWireTracesKeys) {
		var intersections = new ArrayList<String>();
		for (String key : firstWireTracesKeys) {
			if (secondWireTracesKeys.contains(key)) {
				intersections.add(key);
			}
		}
		return intersections;
	}

	private static int getClosestDistanceToPoint(List<String> intersections) {
		int closestDistance = Integer.MAX_VALUE;
		for (String intersection : intersections) {
			String[] split = intersection.split(",");
			int x = Integer.parseInt(split[0]);
			int y = Integer.parseInt(split[1]);

			int abs = Math.abs(x);
			int abs2 = Math.abs(y);
			if (abs + abs2 < closestDistance) {
				closestDistance = abs + abs2;
			}
		}
		return closestDistance;
	}

}
