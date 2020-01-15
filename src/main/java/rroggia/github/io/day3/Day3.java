package rroggia.github.io.day3;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.util.List;

public class Day3 {

	private static final String RESOURCES_FOLDER = "src/main/resources";

	public static void main(String[] args) {

		try {
			var path = FileSystems.getDefault().getPath(RESOURCES_FOLDER, "day3.txt");
			var wireTraces = Files.readAllLines(path);

			var conectionDeterminer = GridConnectionDeterminer.getInstance();

			var firstWireGridConnections = conectionDeterminer.determineConnections(wireTraces.get(0));
			var secondWireGridConnections = conectionDeterminer.determineConnections(wireTraces.get(1));

			var intersectionDeterminer = new GridIntersectionDeterminer();
			var intersections = intersectionDeterminer.determineIntersections(firstWireGridConnections,
					secondWireGridConnections);

			int closestDistance = getClosestDistanceToPoint(intersections);
			System.out.println(closestDistance);

		} catch (IOException e) {
			System.out.println("Error while reading the input file;");
		}
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
