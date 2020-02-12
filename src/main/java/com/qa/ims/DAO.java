package com.qa.ims;

import java.util.ArrayList;

import com.qa.ims.databaseTables.Customer;

public interface DAO<T> {

	public void create(T t);

	public ArrayList<T>view(T t);

	public void update(T t);

	public void delete(int Id);

}
