package com.qa.ims.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import com.qa.ims.Config;
import com.qa.ims.DAO;
import com.qa.ims.databaseTables.Customer;
import com.qa.ims.databaseTables.Orders;
import com.qa.ims.utils.Utils;

public class MySQLOrder implements DAO<Orders> {

	public static final Logger LOGGER = Logger.getLogger(MySQLOrder.class);

//	private Connection connection;

	private String username;
	private String password;

	public MySQLOrder(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public void create(Orders order) {
		System.out.println("Create Order\n");
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://35.246.53.168:3306/IMS", username,
				password);) {

			Statement statement = connection.createStatement();

			System.out.println("Input customer ID\n");
			int customerId = Integer.valueOf(Utils.getInput());
			statement = connection.createStatement();
			statement.executeUpdate("insert into orders(customer_id) values('" Orders. + ")");
			
			
//			("insert into customers(customer_name, customer_surname) values('"
//					+ customer.getName() + "', '" + customer.getSurname() + "')");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Orders> view(Orders order) {

		ArrayList<Orders> orders = new ArrayList<Orders>();
		System.out.println("View Order\n");

		try (Connection connection = DriverManager.getConnection("jdbc:mysql://35.246.53.168:3306/IMS", username,
				password);) {

			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from item where customer_id");
			while (resultSet.next()) {
				int Id = resultSet.getInt("order_id");
				int customerId = resultSet.getInt("customer_id");
				float value = resultSet.getFloat("value");
				Orders order1 = new Orders(Id, customerId, value);
				orders.add(order1);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return orders;
	}

	public void update(Orders order) {
		System.out.println("Update Customer\n");
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://35.246.53.168:3306/IMS", username,
				password)) {

//			System.out.println("What is the customers first name?");
//			String firstname=Utils.getInput();
//			System.out.println("What is the customers surname?");
//			String surname=Utils.getInput();
			Statement statement = connection.createStatement();
			statement.executeUpdate("update orders set customer_id ='" + order.getId() + "', customer_surname ='"
					+ order.getCustomerId() + "' where customer_id =" + order.getId());
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}

	}

	public void delete(int Id) {
		System.out.println("Delete order\n");
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://35.246.53.168:3306/IMS", username,
				password)) {
			Statement statement = connection.createStatement();
			statement.executeUpdate("delete from orders where order_id =" + Id);
//			System.out.println("Id deleted");
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		// TODO Auto-generated method stub
		}
	}

	

}
