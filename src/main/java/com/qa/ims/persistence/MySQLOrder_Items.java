package com.qa.ims.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.qa.ims.DAO;
import com.qa.ims.Runner;
import com.qa.ims.persistence.domain.OrderItem;

public class MySQLOrder_Items implements DAO<OrderItem> {

	public static final Logger LOGGER = Logger.getLogger(MySQLCustomers.class);

	private String username;
	private String password;

	public MySQLOrder_Items(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	private static String searchId;

	public String getSearchId() {
		return searchId;
	}

	public void setSearchId(String searchId) {
		MySQLOrder_Items.searchId = searchId;
	}

	public OrderItem create(OrderItem oi) {

		System.out.println("Create order_ item\n");
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://35.246.53.168:3306/IMS", username,
				password);) {
			Statement statement = connection.createStatement();
			statement.executeUpdate("insert into order_items((item_id, order_id, quantity) values(" + oi.getItemId()
					+ ", " + oi.getOrderId() + ", " + oi.getQuantity() + ")");
			Runner.LOGGER.info("Created Order Item: item_id: " + oi.getItemId() + " order_id:  " + oi.getOrderId()
					+ " quantity: " + oi.getQuantity());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<OrderItem> view() {
		ArrayList<OrderItem> orderItems = new ArrayList<>();
		System.out.println("Veiw order_ item\n");
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://35.246.53.168:3306/IMS", username,
				password);) {

			Statement statement = connection.createStatement();
			ResultSet resultSet = statement
					.executeQuery("select * from order_items");
			while (resultSet.next()) {

				Long itemId = resultSet.getLong("item_id");
				Long orderId = resultSet.getLong("order_id");
				int quantity = resultSet.getInt("quantity");
				OrderItem orderItem = new OrderItem();
				orderItem.setItemId(itemId);
				orderItem.setOrderId(orderId);
				orderItem.setQuantity(quantity);
				orderItems.add(orderItem);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orderItems;
	}

	@Override
	public void update(OrderItem oi) {
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://35.246.53.168:3306/IMS", username,
				password);) {

			Statement statement = connection.createStatement();
			statement.executeUpdate("update order_items set quantity = " + oi.getQuantity() + " where order_id  = "
					+ oi.getOrderId() + "and where item_id = " + oi.getItemId());
			// update order_items set quantity = 5 where order_id = 1 and item_id = 3
			Runner.LOGGER.info("Updated Item Order: " + oi.getOrderId() + " To item_id: " + oi.getItemId()
					+ " quantity: " + oi.getQuantity());

		} catch (Exception e) {
			Runner.LOGGER.info("Error could not update item_order record: " + oi.getOrderId());
			Runner.LOGGER.info(e);
		}

	}

	@Override
	public void delete(int oi) {

		try (Connection connection = DriverManager.getConnection("jdbc:mysql://35.246.53.168:3306/IMS", username,
				password);) {
			Statement statement = connection.createStatement();
			statement.executeUpdate("delete from order_items where order_id = " + oi);
			Runner.LOGGER.info("Deleted Item Order");
		} catch (Exception e) {
			Runner.LOGGER.info("Error could not delete Item Order record");
			Runner.LOGGER.info(e);
		}

	}




}
