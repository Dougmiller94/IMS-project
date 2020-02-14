package com.qa.ims.controller;

import java.util.List;

import org.apache.log4j.Logger;

import com.qa.ims.databaseTables.Customer;
import com.qa.ims.databaseTables.Item;
import com.qa.ims.persistence.MySQLCustomers;
import com.qa.ims.services.CrudServices;
import com.qa.ims.services.ItemServices;
import com.qa.ims.utils.Utils;

public class ItemController implements CrudController<Item> {

	public static final Logger LOGGER = Logger.getLogger(ItemController.class);

	private CrudServices<Item> itemService;

	public ItemController(CrudServices<Item> itemService) {
		this.itemService = itemService;
	}

	String getInput() {
		return Utils.getInput();
	}

	/**
	 * Reads all customers to the logger
	 */

	@Override
	public List<Item> view() {
		List<Item> items = itemService.view();
		for (Item item : items) {
			LOGGER.info(item.getName());

		}
		return items;
	}


	/**
	 * Creates a customer by taking in user input
	 */

	@Override
	public Item create() {
		LOGGER.info("Please enter a item name");
		String name = getInput();
		LOGGER.info("Please enter item value");
		double value = Double.parseDouble(getInput());
		Item item = itemService.create(new Item(name, value));
		LOGGER.info("Item created");
		return item;
	}
	
	
	

	/**
	 * Updates an existing customer by taking in user input
	 */

	@Override
	public void update() {
		LOGGER.info("Please enter the id of the Item you would like to update");
		int id = Integer.valueOf(getInput());
		LOGGER.info("Please enter the item name");
		String name = getInput();
		LOGGER.info("Please enter a value");
		double value = Double.parseDouble(getInput());
		itemService.update(new Item(id, name, value));
		LOGGER.info("Item Updated");
	}

	/**
	 * Deletes an existing customer by the id of the customer
	 */

	@Override
	public void delete() {
		LOGGER.info("Please enter the id of the Item you would like to delete");
		int Id = Integer.parseInt(getInput());
		itemService.delete(Id);
	}

	public String createString(Item item) {
		return item.getName() + " ";
	}

}
