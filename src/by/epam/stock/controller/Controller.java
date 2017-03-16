package by.epam.stock.controller;

import by.epam.stock.command.Command;
import by.epam.stock.command.CommandName;
import by.epam.stock.request.Request;
import by.epam.stock.request.Response;

public class Controller {
	private final CommandProvider provider = new CommandProvider();

	public Response doAction(Request request) {

		CommandName commandName = request.getCommandName();
		Command command = provider.getCommand(commandName);
		Response response = command.execute(request);

		return response;
	}

}
