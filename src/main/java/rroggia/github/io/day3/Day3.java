package rroggia.github.io.day3;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Day3 {

	private static final String RESOURCES_FOLDER = "src/main/resources";

	public static void main(String[] args) {

		try {
			var path = FileSystems.getDefault().getPath(RESOURCES_FOLDER, "day3.txt");
			var wireTraces = Files.readAllLines(path);

			GridConnectionDeterminer grid = new GridConnectionDeterminer();

			var firstWireTracesKeys = grid.determineConnections(wireTraces.get(0));
			var secondWireTracesKeys = grid.determineConnections(wireTraces.get(1));

			var intersections = determineIntersections(firstWireTracesKeys, secondWireTracesKeys);
			int closestDistance = getClosestDistanceToPoint(intersections);
			System.out.println(closestDistance);

		} catch (IOException e) {
			System.out.println("Error while reading the input file;");
		}
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
