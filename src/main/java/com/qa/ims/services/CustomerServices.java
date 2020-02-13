package com.qa.ims.services;

import java.util.List;

import com.qa.ims.DAO;
import com.qa.ims.databaseTables.Customer;
import com.qa.ims.persistence.MySQLCustomers;

public class CustomerServices implements CrudServices<Customer> {

	private DAO<Customer> customerDao;

	public CustomerServices(DAO<Customer> customerDao) {
		this.customerDao = customerDao;
		
	
		
	}
	@Override
	public List<Customer> view () {
		return customerDao.view();
	}

	@Override
	public Customer create(Customer customer) {
		return customerDao.create(customer);
	}

	@Override
	public void update(Customer customer) {
		customerDao.update(customer);
	}

	@Override
	public void delete(int id) {
		customerDao.delete(id);
	}
	
	}

