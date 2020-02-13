package com.qa.ims.services;

import java.util.List;

import com.qa.ims.DAO;
import com.qa.ims.databaseTables.Item;



public class ItemServices implements CrudServices<Item> {

	private DAO<Item> itemsDao;

	public ItemServices(DAO<Item> itemsDao) {
		this.itemsDao = itemsDao;
	}
	@Override
	public List<Item> view() {
		return itemsDao.view();
	}

	@Override
	public Item create(Item item) {
		return itemsDao.create(item);
	}

	@Override
	public void update(Item items) {
		itemsDao.update(items);
	}

	@Override
	public void delete(int Id) {
		itemsDao.delete(Id);
	}

	



}