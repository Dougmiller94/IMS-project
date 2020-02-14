package com.qa.ims.services;

import java.util.List;

import com.qa.ims.DAO;
import com.qa.ims.persistence.domain.OrderItem;

public class OrderItemsServices implements CrudServices<OrderItem> {
	
 

		private DAO<OrderItem> OrderItemsDao;
		
		public OrderItemsServices(DAO<OrderItem> OrderItemsDao) {
			this.OrderItemsDao = OrderItemsDao;
		}
		
		public List<OrderItem> view() {
			return OrderItemsDao.view();
		}

		public OrderItem create(OrderItem oi) {
			return OrderItemsDao.create(oi);
		}

		public void update(OrderItem oi) {
			 OrderItemsDao.update(oi);
		}

		public void delete(int id) {
			OrderItemsDao.delete(id);
		}

	}


