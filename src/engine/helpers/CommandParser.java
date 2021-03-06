package engine.helpers;

import java.util.Scanner;

import command.abstracts.Command;
import command.concrete.AttackCommand;
import command.concrete.ChangeWeaponCommand;
import command.concrete.DownCommand;
import command.concrete.EquiptCommand;
import command.concrete.LeftCommand;
import command.concrete.RightCommand;
import command.concrete.UndoCommand;
import command.concrete.UpCommand;

public class CommandParser {

	private final String WEAPON_KEY_WORD = "use ";
	private final String EQUIPT_KEY_WORD = "equipt ";

	private static CommandParser instance = new CommandParser();
	private static Scanner scanner = new Scanner(System.in);

	private CommandParser() {
	};

	public static CommandParser getInstance() {
		return instance;
	}

	public Command getCommand(String command) {
		if (command.startsWith(WEAPON_KEY_WORD)) {
			return new ChangeWeaponCommand(command.substring(WEAPON_KEY_WORD
					.length()));
		}

		if (command.startsWith(EQUIPT_KEY_WORD)) {
			return new EquiptCommand(
					command.substring(EQUIPT_KEY_WORD.length()));
		}

		switch (command) {
		case "left":
			return new LeftCommand();
		case "right":
			return new RightCommand();
		case "up":
			return new UpCommand();
		case "down":
			return new DownCommand();
		case "attack":
			return new AttackCommand();
		case "undo":
			return new UndoCommand();

		default:
			Logger.getInstance().printMessage("Invalid command!");
			return null;
		}
	}

	public Scanner getScanner() {
		return scanner;
	}

	public void closeScanner() {
		scanner.close();
	}
}
