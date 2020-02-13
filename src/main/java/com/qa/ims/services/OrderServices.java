package com.qa.ims.services;

import java.util.List;

import com.qa.ims.DAO;

import com.qa.ims.databaseTables.Order;

public class OrderServices implements CrudServices<Order> {

	private DAO<Order> OrderDao;

	public OrderServices(DAO<Order> OrderDao) {
		this.OrderDao = OrderDao;
	}
	@Override
	public List<Order> view() {
		return OrderDao.view();
	}

	@Override
	public Order create(Order order) {
		return OrderDao.create(order);
	}

	@Override
	public void update(Order order) {
		OrderDao.update(order);
	}

	@Override
	public void delete(int Id) {
		OrderDao.delete(Id);
	}

	

}
