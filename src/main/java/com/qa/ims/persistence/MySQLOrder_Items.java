package com.qa.ims.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.qa.ims.DAO;
import com.qa.ims.databaseTables.Customer;
import com.qa.ims.databaseTables.OrderItems;

public class MySQLOrder_Items implements DAO<OrderItems> {
	
	
		public static final Logger LOGGER = Logger.getLogger(MySQLCustomers.class);

		private String username;
		private String password;

		public MySQLOrder_Items(String username, String password) {
			super();
			this.username = username;
			this.password = password;
		}
	

	@Override
	public void create(OrderItems ot) {
			
			System.out.println("Create order_ item\n");
			try (Connection connection = DriverManager.getConnection("jdbc:mysql://35.246.53.168:3306/IMS", username,
					password);) {
				Statement statement = connection.createStatement();
				statement.executeUpdate("insert into order_items(customer_name, customer_surname) values('"
						+ customer.getName() + "', '" + customer.getSurname() + "')");

			} catch (Exception e) {
				e.printStackTrace();
			}
	
		
	}

	@Override
	public ArrayList<OrderItems> view(OrderItems ot) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(OrderItems ot) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int Id) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
	

}
