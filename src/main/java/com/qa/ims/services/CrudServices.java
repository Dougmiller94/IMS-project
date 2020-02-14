package com.qa.ims.services;

import java.util.List;

import com.qa.ims.databaseTables.Customer;



public interface CrudServices<T> {

	public List<T> view();

	T create(T t);

	void update(T t);

	void delete(int id);



	

	

}
