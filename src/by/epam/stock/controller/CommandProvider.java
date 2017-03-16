package by.epam.stock.controller;

import java.util.HashMap;
import java.util.Map;

import by.epam.stock.command.Command;
import by.epam.stock.command.CommandName;
import by.epam.stock.command.impl.AddProductCommand;
import by.epam.stock.command.impl.GetProductCommand;
import by.epam.stock.command.impl.ShowProductByAnnotationCommand;
import by.epam.stock.command.impl.ShowProductByAnnotationContainCommand;
import by.epam.stock.command.impl.ShowProductByCodeCommand;
import by.epam.stock.command.impl.ShowProductByNameAndCodeCommand;
import by.epam.stock.command.impl.ShowProductByNameCommand;
import by.epam.stock.command.impl.ShowProductByProductDateCommand;
import by.epam.stock.command.impl.ShowSortedProductCommand;

final class CommandProvider {
	private final Map<CommandName, Command> provider = new HashMap<>();

	CommandProvider() {
		provider.put(CommandName.GET_PRODUCT, new GetProductCommand());
		provider.put(CommandName.GET_SORTED_PRODUCT, new ShowSortedProductCommand());
		provider.put(CommandName.SHOW_PRODUCT_BY_NAME, new ShowProductByNameCommand());
		provider.put(CommandName.SHOW_PRODUCT_BY_CODE, new ShowProductByCodeCommand());
		provider.put(CommandName.SHOW_PRODUCT_BY_ANNOTATION, new ShowProductByAnnotationCommand());
		provider.put(CommandName.SHOW_PRODUCT_BY_PRODUCTDATE, new ShowProductByProductDateCommand());
		provider.put(CommandName.SHOW_PRODUCT_BY_NAME_AND_CODE, new ShowProductByNameAndCodeCommand());
		provider.put(CommandName.SHOW_PRODUCT_BY_ANNOTATION_CONTAIN, new ShowProductByAnnotationContainCommand());
		provider.put(CommandName.ADD_PRODUCT, new AddProductCommand());

	}

	public Command getCommand(CommandName commandName) {
		Command command;
		command = provider.get(commandName);
		return command;
	}
}
