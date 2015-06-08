package command.concrete;

import java.util.Scanner;

import command.abstracts.Command;

public class CommandParser {

	private static CommandParser instance = new CommandParser();
	private static Scanner scanner = new Scanner(System.in);

	private CommandParser() {
	};

	public static CommandParser getInstance() {
		return instance;
	}

	public Command getCommand(String command) {
		switch (command) {
		case "left":
			return new LeftCommand();
		case "right":
			return new RightCommand();
		case "up":
			return new UpCommand();
		case "down":
			return new DownCommand();

		default:
			throw new IllegalStateException("Invalid command!");
		}
	}

	public Scanner getScanner() {
		return scanner;
	}

	public void close(){
		scanner.close();
	}
}
