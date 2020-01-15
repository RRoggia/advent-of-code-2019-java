package rroggia.github.io.day3;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class GridIntersectionDeterminer {

	private static final GridIntersectionDeterminer INSTANCE = new GridIntersectionDeterminer();

	private GridIntersectionDeterminer() {

	}

	public static GridIntersectionDeterminer getInstance() {
		return INSTANCE;
	}

	public List<String> determineIntersections(Set<String> firstConections, Set<String> secondConections) {
		var intersections = new ArrayList<String>();
		for (String key : firstConections) {
			if (secondConections.contains(key)) {
				intersections.add(key);
			}
		}
		return intersections;
	}

}
