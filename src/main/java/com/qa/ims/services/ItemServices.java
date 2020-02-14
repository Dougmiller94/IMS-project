package com.qa.ims.services;

import java.util.List;

import com.qa.ims.DAO;
import com.qa.ims.databaseTables.Item;



public class ItemServices implements CrudServices<Item> {
	static int id=0;
	private static DAO<Item> itemsDao;

	public ItemServices(DAO<Item> itemsDao) {
		ItemServices.itemsDao = itemsDao;
	}
	public List<Item> view() {
		return itemsDao.view();
	}

	public Item create(String name, double value) {
		id++;
		return itemsDao.create(new Item(id,name, value));
	}

	@Override
	public void update(Item items) {
		itemsDao.update(items);
	}

	@Override
	public void delete(int Id) {
		itemsDao.delete(Id);
	}
	@Override
	public Item create(Item t) {
		// TODO Auto-generated method stub
		return null;
	}

}
