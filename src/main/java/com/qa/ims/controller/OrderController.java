package com.qa.ims.controller;

import java.util.List;

import org.apache.log4j.Logger;

import com.qa.ims.databaseTables.Customer;
import com.qa.ims.databaseTables.Order;

import com.qa.ims.services.CrudServices;
import com.qa.ims.services.OrderServices;
import com.qa.ims.utils.Utils;

public class OrderController implements CrudController<Order> {

	public static final Logger LOGGER = Logger.getLogger(OrderController.class);

	private CrudServices<Order> orderServices;

	public OrderController(CrudServices<Order> orderServices) {
		this.orderServices = orderServices;
	}

	String getInput() {
		return Utils.getInput();
	}

	/**
	 * Reads all customers to the logger
	 */

	@Override
	public List<Order> view() {
		List<Order> orders = orderServices.view();
		for (Order order : orders) {
			LOGGER.info(order.toString());
		}
		return orders;
	}

	/**
	 * Creates a customer by taking in user input
	 */
	@Override
	public Order create() {
		LOGGER.info("Please enter a customer Id");
		int Id = getInput();
		LOGGER.info("Please enter item name");
		double value = getInput();
		Order order = orderServices.create(new Order(name, value));
		LOGGER.info("Item created");
		return order;
	}

	/**
	 * Updates an existing customer by taking in user input
	 */
	@Override
	public void update() {
		LOGGER.info("Please enter the id of the order you would like to update");
		int id = Integer.valueOf(getInput());
		LOGGER.info("Please enter the item name");
		String name = getInput();
		LOGGER.info("Please enter a value");
		double value = Double.parseDouble(getInput());
		orderServices.update(new Order(id, value));
		LOGGER.info("Order Updated");
	}

	/**
	 * Deletes an existing customer by the id of the customer
	 */
	@Override
	public void delete() {
		LOGGER.info("Please enter the id of the Item you would like to delete");
		int id = Integer.valueOf(getInput());
		orderServices.delete(id);
	}

}
