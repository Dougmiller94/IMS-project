package com.qa.ims;

import org.apache.log4j.Logger;

import com.qa.ims.databaseTables.Customer;
import com.qa.ims.databaseTables.Item;
import com.qa.ims.persistence.MySQLCustomers;
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

		MySQLCustomers dao = new MySQLCustomers(username, password);
		
		
//		LOGGER.info("What is customer name and surname?");
//		Customer customer = new Customer(Utils.getInput(),Utils.getInput());
//		dao.update(customer);
//
//	}

	
	
//	Item item = new Item(Utils.getInput(),Utils.getInput());
//	dao.update(item);
}
}