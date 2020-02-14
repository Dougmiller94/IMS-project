package com.qa.ims.services;

import java.util.List;

import com.qa.ims.DAO;
import com.qa.ims.databaseTables.OrderItems;
import com.qa.ims.persistence.MySQLOrder_Items;

public class OrderItemsServices implements CrudServices<OrderItems> {
	
 

		private DAO<OrderItems> OrderItemsDao;
		
		public OrderItemsServices(DAO<OrderItems> OrderItemsDao) {
			this.OrderItemsDao = OrderItemsDao;
		}
		
		public List<OrderItems> view() {
			return OrderItemsDao.view();
		}

		public OrderItems create(OrderItems oi) {
			return OrderItemsDao.create(oi);
		}

		public void update(OrderItems oi) {
			 OrderItemsDao.update(oi);
		}

		public void delete(int id) {
			OrderItemsDao.delete(id);
		}

	}


