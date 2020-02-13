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
import com.qa.ims.databaseTables.OrderItems;
import com.qa.ims.utils.Utils;

public class MySQLCustomers implements DAO<Customer> {

	public static final Logger LOGGER = Logger.getLogger(MySQLCustomers.class);

	private String username;
	private String password;

	public MySQLCustomers(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	@Override
	public Customer create(Customer customer) {
		System.out.println("Create Customer\n");
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://35.246.53.168:3306/IMS", username,
				password);) {
			Statement statement = connection.createStatement();
			statement.executeUpdate("insert into customers(customer_name, customer_surname) values('"
					+ customer.getName() + "', '" + customer.getSurname() + "')");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return customer;
	}

	@Override
	public ArrayList<Customer> view() {
		ArrayList<Customer> customers = new ArrayList<Customer>();
		System.out.println("View Customer\n");

		try (Connection connection = DriverManager.getConnection("jdbc:mysql://35.246.53.168:3306/IMS", username,
				password);) {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from customers");
			while (resultSet.next()) {
				int Id = resultSet.getInt("customer_id");
				String name = resultSet.getString("customer_name");
				String surname = resultSet.getString("customer_surname");
				Customer customer = new Customer(Id, name, surname);
				customers.add(customer);
				System.out.println(Id + " " + name + " " + surname);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return customers;

	}

	@Override
	public void update(Customer customer) {
		System.out.println("Update Customer\n");
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://35.246.53.168:3306/IMS", username,
				password)) {
			Statement statement = connection.createStatement();
//			System.out.println("What is the customers first name?");
//			String firstname=Utils.getInput();
//			System.out.println("What is the customers surname?");
//			String surname=Utils.getInput();
			statement = connection.createStatement();
			statement.executeUpdate("update customers set customer_name ='" + customer.getName()
					+ "', customer_surname ='" + customer.getSurname() + "' where customer_id =" + customer.getId());
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
//		System.out.println("Customer Updated");

	}

	@Override
	public void delete(int Id) {
		System.out.println("Delete Customer\n");
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://35.246.53.168:3306/IMS", username,
				password)) {
			Statement statement = connection.createStatement();
			statement.executeUpdate("delete from customers where customer_id =" + Id);
//			System.out.println("Id deleted");
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());

		}
	}

}
