package com.qa.ims.controller;
import java.util.List;

import org.apache.log4j.Logger;

import com.qa.ims.databaseTables.Customer;
import com.qa.ims.services.CrudServices;
import com.qa.ims.utils.Utils;

public class CustomerController implements CrudController<Customer> {

	/**
	 * Takes in customer details for CRUD functionality
	 *
	 */

	public static final Logger LOGGER = Logger.getLogger(CustomerController.class);

	private CrudServices<Customer> customerService;

	public CustomerController(CrudServices<Customer> customerService) {
		this.customerService = customerService;
	}

	String getInput() {
		return Utils.getInput();
	}

	/**
	 * Reads all customers to the logger
	 */
	
	@Override
	public List<Customer> view() {
		List<Customer> customers = customerService.view();
		for (Customer customer1 : customers) {
			LOGGER.info(customer1.toString());
		}
		return customers;
	}

	/**
	 * Creates a customer by taking in user input
	 */
	
	@Override
	public Customer create() {
		LOGGER.info("Please enter a first name");
		String name = getInput();
		LOGGER.info("Please enter a surname");
		String surname = getInput();
		Customer customer = customerService.create(new Customer(name, surname));
		LOGGER.info("Customer created");
		return customer;
	}

	/**
	 * Updates an existing customer by taking in user input
	 */
	
	@Override
	public void update() {
		LOGGER.info("Please enter the id of the customer you would like to update");
		int id = Integer.valueOf(getInput());
		LOGGER.info("Please enter a first name");
		String name = getInput();
		LOGGER.info("Please enter a surname");
		String surname = getInput();
		customerService.update(new Customer(id, name, surname));
		LOGGER.info("Customer Updated");
	}

	/**
	 * Deletes an existing customer by the id of the customer
	 */
	
	@Override
	public void delete() {
		LOGGER.info("Please enter the id of the customer you would like to delete");
		int id = Integer.valueOf(getInput());
		customerService.delete(id);
	}

}
