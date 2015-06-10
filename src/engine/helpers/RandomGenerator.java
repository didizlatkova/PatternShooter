package engine.helpers;

import java.util.List;
import java.util.Random;

import command.abstracts.MoveCommand;
import elements.abstracts.FieldElement;

public class RandomGenerator {

	private static RandomGenerator instance = new RandomGenerator();
	private static Random rnd = new Random();

	private RandomGenerator() {
	};

	public static RandomGenerator getInstance() {
		return instance;
	}

	public int[] getFreeFieldPosition(FieldElement[][] elements) {
		int randomX = rnd.nextInt(elements.length);
		int randomY = rnd.nextInt(elements[0].length);

		while (elements[randomX][randomY] != null) {
			randomX = rnd.nextInt(elements.length);
			randomY = rnd.nextInt(elements[0].length);
		}

		return new int[] { randomX, randomY };
	}

	public MoveCommand getCommand(List<MoveCommand> possibleCommands) {
		int index = rnd.nextInt(possibleCommands.size());
		return possibleCommands.get(index);
	}
	
}
