package by.epam.stock.command;

import by.epam.stock.request.Request;
import by.epam.stock.request.Response;

public interface Command {
	public Response execute(Request request); 
}
