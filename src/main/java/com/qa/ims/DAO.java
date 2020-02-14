package com.qa.ims;

import java.util.ArrayList;

public interface DAO<T> {

	public T create(T t);

	public ArrayList<T> view();

	public void update(T t);

	public void delete(int Id);

	

}
