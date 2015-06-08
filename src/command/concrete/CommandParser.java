package command.concrete;

import command.abstracts.Command;

public class CommandParser {

	private static CommandParser instance = new CommandParser();

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

}
