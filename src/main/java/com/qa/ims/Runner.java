package com.qa.ims;

import org.apache.log4j.Logger;

import com.qa.ims.databaseTables.Item;

import com.qa.ims.persistence.MySQLItem;

import com.qa.ims.utils.Utils;

public class Runner {

	public static final Logger LOGGER = Logger.getLogger(Runner.class);

	public static void main(String[] args) {
		System.out.println("enter username");
		String username = Utils.getInput();
		System.out.println("enter password");
		String password = Utils.getInput();

//		MySQLCustomers dao = new MySQLCustomers(username, password);
//		Customer customer = new Customer(1, "Doug", "Miller");

		MySQLItem dao = new MySQLItem(username, password);
		Item items = new Item(1, "P90", 345.23);
		dao.create(items);

	}

}
