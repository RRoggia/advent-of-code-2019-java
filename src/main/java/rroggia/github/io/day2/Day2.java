package rroggia.github.io.day2;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.util.Arrays;

public class Day2 {
	private static final String RESOURCES_FOLDER = "src/main/resources";

	public static void main(String[] args) {

		try {
			var path = FileSystems.getDefault().getPath(RESOURCES_FOLDER, "day2.txt");
			var opcodes = Files.readString(path);

			String[] split = opcodes.split(",");
			String noun = "12";
			String verb = "2";

			split[1] = noun;
			split[2] = verb;
			var changedOpcodes = String.join(",", Arrays.asList(split));

			var opcodeReader = new OpcodeReader(changedOpcodes);
			opcodeReader.resolveAllOpcodes();
			System.out.println(opcodeReader.getOpcodeCurrentState());
		} catch (IOException e) {
			System.out.println("Error reading the day2.txt file.");
		}

	}

}
