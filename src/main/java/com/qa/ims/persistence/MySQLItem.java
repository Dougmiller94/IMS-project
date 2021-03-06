package com.qa.ims.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.qa.ims.DAO;
import com.qa.ims.persistence.domain.Item;

public class MySQLItem implements DAO<Item> {

	public static final Logger LOGGER = Logger.getLogger(MySQLCustomers.class);

	private String username;
	private String password;

	public MySQLItem(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public Item create(Item item) {
		System.out.println("Create Item\n");
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://35.246.53.168:3306/IMS", username,
				password);) {
			Statement statement = connection.createStatement();
			statement.executeUpdate("insert into items(item_name, item_value) values('" + item.getItemName() + "' , '"
					+ item.getValue() + "')");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return item;
	}

	public ArrayList<Item> view() {

		ArrayList<Item> items = new ArrayList<Item>();
		System.out.println("View Item\n");
		ResultSet resultSet;
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://35.246.53.168:3306/IMS", username,
				password);) {
			Statement statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from items");
			while (resultSet.next()) {
				Long Id = resultSet.getLong("item_id");
				String name = resultSet.getString("item_name");
				double value = resultSet.getDouble("item_value");
				Item item = new Item(Id, name, value);
				items.add(item);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return items;
	}

	public void update(Item item) {
		System.out.println("Update Item\n");
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://35.246.53.168:3306/IMS", username,
				password);) {
			Statement statement = connection.createStatement();
			statement.executeUpdate("update Items set item_id ='" + item.getId() + +item.getValue()
					+ "' where item_id =" + item.getId());
			System.out.println("Item updated");
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
	}

	public void delete(int id) {
		System.out.println("Delete Item\n");
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://35.246.53.168:3306/IMS", username,
				password);) {
			Statement statement = connection.createStatement();
			statement.executeUpdate("delete from items where item_id =" + id);
			System.out.println("Id deleted");
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());

		}
	}

}
