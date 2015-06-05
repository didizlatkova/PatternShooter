package engine.concrete;

import java.util.Random;

import visitor.abstracts.FieldElement;

public class RandomGenerator {

	private static RandomGenerator instance = new RandomGenerator();

	private RandomGenerator() {
	};

	public static RandomGenerator getInstance() {
		return instance;
	}

	public int[] getFreeFieldPosition(FieldElement[][] elements) {
		Random rnd = new Random();
		int randomX = rnd.nextInt(elements.length);
		int randomY = rnd.nextInt(elements[0].length);

		while (elements[randomX][randomY] != null) {
			randomX = rnd.nextInt(elements.length);
			randomY = rnd.nextInt(elements[0].length);
		}

		return new int[] { randomX, randomY };
	}
}
