package by.epam.stock.request;

import by.epam.stock.command.CommandName;

public class Request {
	private CommandName commandName;

	public CommandName getCommandName() {
		return commandName;
	}

	public void setCommandName(CommandName commandName) {
		this.commandName = commandName;
	}

}
