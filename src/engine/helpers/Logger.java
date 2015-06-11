package engine.helpers;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Logger {

	private static Logger instance = new Logger();

	private Logger() {
	}

	public static Logger getInstance() {
		return instance;
	}

	public void printRules(String fileName) {
		try {
			Scanner in = new Scanner(new FileReader(fileName));
			while (in.hasNext()) {
				this.printMessage(in.nextLine());
			}
			in.close();

		} catch (FileNotFoundException e) {
			// do not print any rules
		}

	}

	public void promptUser() {
		this.printMessage("It's your turn!");
	}

	public void printMessage(String message) {
		System.out.println(message);
	}

}
