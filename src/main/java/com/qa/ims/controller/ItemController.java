package com.qa.ims.controller;

import java.util.List;

import org.apache.log4j.Logger;

import com.qa.ims.databaseTables.Customer;
import com.qa.ims.databaseTables.Item;
import com.qa.ims.services.CrudServices;
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
			List<Item> items = ItemServices.veiw();
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
			double value = getInput();
			Item item = ItemServices.create(new Item(name, value));
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
			double value = getInput();
			Item item = ItemServices.update(new Item(id, name, value));
			LOGGER.info("Item Updated");
			return item;
		}

		/**
		 * Deletes an existing customer by the id of the customer
		 */
		@Override
		public void delete() {
			LOGGER.info("Please enter the id of the Item you would like to delete");
			double Id = Integer.valueOf(getInput());
			ItemServices.delete(Id);
		}
		
		
		private String createString(Item item) {
			return item.getName() + " ";
		}

		@Override
		public List<Item> view(Item t) {
			// TODO Auto-generated method stub
			return null;
		}



	}


