package com.qa.ims;

import org.apache.log4j.Logger;

import com.qa.ims.databaseTables.Customer;
import com.qa.ims.databaseTables.Items;
import com.qa.ims.databaseTables.Orders;
import com.qa.ims.persistence.MySQLCustomers;
import com.qa.ims.persistence.MySQLItems;
import com.qa.ims.persistence.MySQLOrder;
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
		
		MySQLItems dao = new MySQLItems(username, password);
		Items items = new Items(1, "P90", 345.23);
		dao.create(items);
		
		
		
		
		
		
		

	}

}
