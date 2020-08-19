package by.itacademy.mhl.controller;

import java.util.HashMap;
import java.util.Map;

import by.itacademy.mhl.controller.impl.*;

public class CommandProvider {

	private Map<CommandName, Command> commands = new HashMap<CommandName, Command>();

	public CommandProvider() {
		commands.put(CommandName.LOGINATION, new LoginationCommand());
		commands.put(CommandName.REGISTRATION, new RegistrationCommand());
		commands.put(CommandName.EDITING, new EditNoteCommand());
		commands.put(CommandName.ADDING, new AddNoteCommand());
		commands.put(CommandName.ALLCATALOGUE, new ShowAllCatalogueCommand());
		commands.put(CommandName.FINDBYAUTHOR, new FindAllByAuthorCommand());
		commands.put(CommandName.FINDBYCATEGORY, new FindAllByCategoryCommand());
		commands.put(CommandName.DELETENOTE, new DeleteNoteCommand());
		commands.put(CommandName.NO_SUCH_COMMAND, new NoSuchCommand());

	}

	public Command takeCommand(String command) {
		CommandName commandName;
		Command value;

		try {
			commandName = CommandName.valueOf(command.toUpperCase());
			value = commands.get(commandName);
		} catch (Exception e) {
			value = commands.get(CommandName.NO_SUCH_COMMAND);
		}
		
		return value;

	}

}
