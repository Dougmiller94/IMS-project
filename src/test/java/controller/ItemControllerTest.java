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

import com.qa.ims.controller.ItemController;
import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.services.ItemServices;

@RunWith(MockitoJUnitRunner.class)
public class ItemControllerTest {

	/**
	 * The thing I want to fake functionlity for
	 */
	@Mock
	private ItemServices itemServices;

	/**
	 * Spy is used because i want to mock some methods inside the item I'm testing
	 * InjectMocks uses dependency injection to insert the mock into the customer
	 * controller
	 */
	@Spy
	@InjectMocks
	private ItemController itemController;

	@Test
	public void viewTest() {
		List<Item> items = new ArrayList<>();
		items.add(new Item(1L,"Pepsi",5.0));
		Mockito.doReturn(items).when(itemServices).view();
		assertEquals(items, itemController.view());
	}

	@Test
	public void createTest() {
		String name = "Perrins";
		String price = "5.0";
		Mockito.doReturn(name).doReturn(price).when(itemController).getInput();
		Item savedItem = new Item(1L,name,5.0);
		Mockito.doReturn(savedItem).when(itemServices).create(Mockito.any(Item.class));
		assertEquals(savedItem, itemController.create());
	}

	/**
	 * 
	 */
	@Test
	public void updateTest() {
		Mockito.doReturn("1").doReturn("TestName").doReturn("5.0").when(itemController).getInput();
//		Mockito.when(customerServices.update(Mockito.any(Customer.class))).thenReturn(customer);
		itemController.update();
		Mockito.verify(itemServices,Mockito.times(1)).update(new Item(1L,"TestName",5.0));
//		assertEquals(customer, customerController.update());
	}

	/**
	 * Delete doesn't return anything, so we can just verify that it calls the
	 * delete method
	 */
	@Test
	public void deleteTest() {
		String id = "1";
		Mockito.doReturn(id).when(itemController).getInput();
		itemController.delete();
		Mockito.verify(itemServices, Mockito.times(1)).delete(1);
	}
}
