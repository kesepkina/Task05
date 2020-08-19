package by.itacademy.mhl.controller;

public class Controller {

	private final CommandProvider provider = new CommandProvider();

	public String doAction(String request) {
		String[] params;

		params = request.split("\\t");

		Command currentCommand;
		String response = null;

		currentCommand = provider.takeCommand(params[0]);

		response = currentCommand.execute(params);

		return response;
	}

}
