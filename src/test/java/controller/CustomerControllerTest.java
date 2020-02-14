package controller;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.controller.CustomerController;
import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.services.CustomerServices;

@RunWith(MockitoJUnitRunner.class)
public class CustomerControllerTest {

	/**
	 * The thing I want to fake functionlity for
	 */
	@Mock
	private CustomerServices customerServices;

	/**
	 * Spy is used because i want to mock some methods inside the item I'm testing
	 * InjectMocks uses dependency injection to insert the mock into the customer
	 * controller
	 */
	@Spy
	@InjectMocks
	private CustomerController customerController;

	@Test
	public void viewTest() {
		List<Customer> customers = new ArrayList<>();
		customers.add(new Customer("Chris", "P"));
		customers.add(new Customer("Rhys", "T"));
		customers.add(new Customer("Nic", "J"));
		Mockito.doReturn(customers).when(customerServices).view();
		assertEquals(customers, customerController.view());
	}

	@Test
	public void createTest() {
		String firstName = "Chris";
		String surname = "Perrins";
		Mockito.doReturn(firstName, surname).when(customerController).getInput();
		Customer savedCustomer = new Customer(1L, "Chris", "Perrins");
		Mockito.doReturn(savedCustomer).when(customerServices).create(Mockito.any(Customer.class));
		assertEquals(savedCustomer, customerController.create());
	}

	/**
	 * 
	 */
	@Test
	public void updateTest() {
		String id = "1";
		String firstName = "Rhys";
		String surname = "Thompson";
		Mockito.doReturn(id).doReturn(firstName).doReturn(surname).when(customerController).getInput();
		Customer customer = new Customer(1L, firstName, surname);
//		Mockito.when(customerServices.update(Mockito.any(Customer.class))).thenReturn(customer);
		customerController.update();
		Mockito.verify(customerServices,Mockito.times(1)).update(customer);
//		assertEquals(customer, customerController.update());
	}

	/**
	 * Delete doesn't return anything, so we can just verify that it calls the
	 * delete method
	 */
	@Test
	public void deleteTest() {
		String id = "1";
		Mockito.doReturn(id).when(customerController).getInput();
		customerController.delete();
		Mockito.verify(customerServices, Mockito.times(1)).delete(1);
	}

}
