package com.qa.ims;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import com.qa.ims.controller.CrudController;
import com.qa.ims.controller.CustomerController;
import com.qa.ims.persistence.MySQLCustomers;
import com.qa.ims.persistence.domain.Domain;
import com.qa.ims.services.CustomerServices;
import com.qa.ims.utils.Utils;



public class IMS {
	


		public static final Logger LOGGER = Logger.getLogger(IMS.class);

		public void IMSSystem() {
			LOGGER.info("Username");
			String username = Utils.getInput();
			LOGGER.info("What is your password");
			String password = Utils.getInput();

			init(username, password);

			LOGGER.info("Which entity would you like to use?");
			Domain.printDomains();

			Domain domain = Domain.getDomain();
			LOGGER.info("What would you like to do with " + domain.name().toLowerCase() + ":");

			Action.printActions();
			Action action = Action.getAction();

			switch (domain) {
			case CUSTOMER:
				CustomerController customerController = new CustomerController(
						new CustomerServices(new MySQLCustomers(username, password)));
				doAction(customerController, action);
				break;
			case ITEM:
				break;
			case ORDER:
				break;
			case STOP:
				break;
			default:
				break;
			}

		}

		public void doAction(CrudController<?> crudController, Action action) {
			switch (action) {
			case CREATE:
				crudController.create();
				break;
			case VIEW:
				crudController.view();
				break;
			case UPDATE:
				crudController.update();
				break;
			case DELETE:
				crudController.delete();
				break;
			case RETURN:
				break;
			default:
				break;
			}
		}

		/**
		 * To initialise the database schema. DatabaseConnectionUrl will default to
		 * localhost.
		 * 
		 * @param username
		 * @param password
		 */
		public void init(String username, String password) {
			init("jdbc:mysql://localhost:3306/", username, password, "src/main/resources/sql-schema.sql");
		}

		public String readFile(String fileLocation) {
			StringBuilder stringBuilder = new StringBuilder();
			try (BufferedReader br = new BufferedReader(new FileReader(fileLocation));) {
				String string;
				while ((string = br.readLine()) != null) {
					stringBuilder.append(string);
					stringBuilder.append("\r\n");
				}
			} catch (IOException e) {
				for (StackTraceElement ele : e.getStackTrace()) {
					LOGGER.debug(ele);
				}
				LOGGER.error(e.getMessage());
			}
			return stringBuilder.toString();
		}

		/**
		 * To initialise the database with the schema needed to run the application
		 */
		public void init(String jdbcConnectionUrl, String username, String password, String fileLocation) {
			try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
					BufferedReader br = new BufferedReader(new FileReader(fileLocation));) {
				String string;
				while ((string = br.readLine()) != null) {
					try (Statement statement = connection.createStatement();) {
						statement.executeUpdate(string);
					}
				}
			} catch (SQLException | IOException e) {
				for (StackTraceElement ele : e.getStackTrace()) {
					LOGGER.debug(ele);
				}
				LOGGER.error(e.getMessage());
			}
		}

	}


