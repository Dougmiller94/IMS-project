package com.qa.ims.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import com.qa.ims.DAO;
import com.qa.ims.Runner;

import com.qa.ims.databaseTables.Order;

public class MySQLOrder implements DAO<Order> {

	public static final Logger LOGGER = Logger.getLogger(MySQLOrder.class);

	private String username;
	private String password;

	public MySQLOrder(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public Order create(Order order) {
		System.out.println("Create Order\n");
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://35.246.53.168:3306/IMS", username,
				password);) {

			Statement statement = connection.createStatement();
			statement.executeUpdate("insert into orders(customer_id) values(" + order.getCustomerId() + ")");
			Runner.LOGGER.info("Order added");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


	public ArrayList<Order> view() {

		ArrayList<Order> orders = new ArrayList<Order>();
		System.out.println("View Order\n");

		try (Connection connection = DriverManager.getConnection("jdbc:mysql://35.246.53.168:3306/IMS", username,
				password);) {

			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from item");
			while (resultSet.next()) {
				int Id = resultSet.getInt("order_id");
				int customerId = resultSet.getInt("customer_id");
				float value = resultSet.getFloat("value");
				Order order1 = new Order(Id, customerId, value);
				orders.add(order1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orders;
	}

	public void update(Order order) {
		System.out.println("Update Customer\n");
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://35.246.53.168:3306/IMS", username,
				password)) {

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

		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());

		}
	}

}
