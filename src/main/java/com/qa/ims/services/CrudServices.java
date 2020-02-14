package com.qa.ims.services;

import java.util.List;



public interface CrudServices<T> {

	public List<T> view();

	T create(T t);

	void update(T t);

	void delete(int id);



	

	

}
