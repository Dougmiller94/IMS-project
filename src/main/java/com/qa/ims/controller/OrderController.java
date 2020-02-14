package com.qa.ims.controller;

import java.util.List;

import org.apache.log4j.Logger;

import com.qa.ims.persistence.domain.Order;
import com.qa.ims.services.CrudServices;
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
		Long Id = Long.parseLong(getInput());
		LOGGER.info("Please enter total value");
		Long value = Long.parseLong(getInput());
		Order order = orderServices.create(new Order(1L, Id,value));
		LOGGER.info("Item created");
		return order;
	}

	/**
	 * Updates an existing customer by taking in user input
	 */
	@Override
	public void update() {
		LOGGER.info("Please enter the id of the order you would like to update");
		Long id = Long.valueOf(getInput());
		LOGGER.info("Please enter a customer Id");
		Long custId = Long.parseLong(getInput());

		LOGGER.info("Please enter a value");
		Long value = Long.parseLong(getInput());
		orderServices.update(new Order(id, custId,value));
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
