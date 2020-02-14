package persistence.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.persistence.domain.Customer;

@RunWith(MockitoJUnitRunner.class)
public class CustomerTest {
	private Customer customer;
	
	@Before
	public void init() {
		customer = new Customer(1L,"One","Two");
	}
	
	@Test
	public void getSetTest() {
		customer.setId(2L);
		
		assertTrue(customer.getId().equals(2L));
		customer.setFirstName("Chris");
		assertEquals("Chris",customer.getFirstName());
		customer.setSurname("Perrins");
		assertEquals("Perrins",customer.getSurname());
	}
	
}
