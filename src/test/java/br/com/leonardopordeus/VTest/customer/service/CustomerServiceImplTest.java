package br.com.leonardopordeus.VTest.customer.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import br.com.leonardopordeus.VTest.BusinessException;
import br.com.leonardopordeus.VTest.customer.dao.CustomerDao;
import br.com.leonardopordeus.VTest.customer.entity.Address;
import br.com.leonardopordeus.VTest.customer.entity.Customer;

class CustomerServiceImplTest {

	CustomerService customerService;
	CustomerDao customerDao;

	@BeforeEach
	public void setup() {
		customerDao = mock(CustomerDao.class);
		customerService = new CustomerServiceImpl(customerDao);
	}

	@Test
	void testGet_001() throws BusinessException {
		Customer expectedCustomer = new Customer();
		expectedCustomer.setId(1l);
		Optional<Customer> expected = Optional.of(expectedCustomer);
		doReturn(expected).when(customerDao).findById(1l);
		Customer result = customerService.get(1l);
		Assert.notNull(result, "result.null");
	}

	@Test
	void testGet_002() throws BusinessException {
		Customer expectedCustomer = new Customer();
		expectedCustomer.setId(1l);
		Optional<Customer> expected = Optional.of(expectedCustomer);
		doReturn(expected).when(customerDao).findById(1l);
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			customerService.get(null);
		});
	}

	@Test
	void testGet_003() throws BusinessException {
		Customer expectedCustomer = new Customer();
		expectedCustomer.setId(1l);
		Optional<Customer> expected = Optional.empty();
		doReturn(expected).when(customerDao).findById(1l);
		Assertions.assertThrows(BusinessException.class, () -> {
			customerService.get(1l);
		});
	}

	@Test
	void testSave_001() throws BusinessException {
		Customer customer = new Customer();
		customer.setName("Name");
		customer.setDocumentId("DocumentId");
		customer.setAge(1);

		Address address = new Address();
		address.setId(1l);
		address.setZipCode("99999-999");

		List<Address> addresses = new ArrayList<>();
		addresses.add(address);
		customer.setAddresses(addresses);

		Customer expectedCustomer = new Customer();
		expectedCustomer.setId(1l);
		expectedCustomer.setName("Name");
		expectedCustomer.setDocumentId("DocumentId");
		expectedCustomer.setAge(1);

		doReturn(new ArrayList<Customer>()).when(customerDao).findByDocumentId("DocumentId");
		doReturn(expectedCustomer).when(customerDao).save(any(Customer.class));

		Customer result = customerService.save(customer);

		Assert.notNull(result, "result.not.null");
		Assert.isTrue("DocumentId".equals(result.getDocumentId()), "result.DocumentId");
		Assert.isTrue("Name".equals(result.getName()), "result.Name");
		Assert.isTrue(result.getAge().equals(1), "result.Age");
	}

	@Test
	void testSave_002() throws BusinessException {
		Customer customer = new Customer();
		customer.setName("Name");
//		customer.setDocumentId("DocumentId");
		customer.setAge(1);

		Address address = new Address();
		address.setId(1l);
		address.setZipCode("99999-999");

		List<Address> addresses = new ArrayList<>();
		addresses.add(address);
		customer.setAddresses(addresses);

		Customer expectedCustomer = new Customer();
		expectedCustomer.setId(1l);
		expectedCustomer.setName("Name");
		expectedCustomer.setDocumentId("DocumentId");
		expectedCustomer.setAge(1);

		doReturn(new ArrayList<Customer>()).when(customerDao).findByDocumentId("DocumentId");
		doReturn(expectedCustomer).when(customerDao).save(any(Customer.class));

		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			customerService.save(customer);
		});

	}

	@Test
	void testSave_004() throws BusinessException {
		Customer customer = new Customer();
		customer.setName("Name");
		customer.setDocumentId("DocumentId");
		customer.setAge(1);

		Address address = new Address();
		address.setId(1l);
//		address.setZipCode("99999-999");

		List<Address> addresses = new ArrayList<>();
		addresses.add(address);
		customer.setAddresses(addresses);

		Customer expectedCustomer = new Customer();
		expectedCustomer.setId(1l);
		expectedCustomer.setName("Name");
		expectedCustomer.setDocumentId("DocumentId");
		expectedCustomer.setAge(1);

		doReturn(new ArrayList<Customer>()).when(customerDao).findByDocumentId("DocumentId");
		doReturn(expectedCustomer).when(customerDao).save(any(Customer.class));

		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			customerService.save(customer);
		});
	}

	@Test
	void testSave_003() throws BusinessException {
		Customer customer = new Customer();
//		customer.setName("Name");
		customer.setDocumentId("DocumentId");
		customer.setAge(1);

		Address address = new Address();
		address.setId(1l);
		address.setZipCode("99999-999");

		List<Address> addresses = new ArrayList<>();
		addresses.add(address);
		customer.setAddresses(addresses);

		Customer expectedCustomer = new Customer();
		expectedCustomer.setId(1l);
		expectedCustomer.setName("Name");
		expectedCustomer.setDocumentId("DocumentId");
		expectedCustomer.setAge(1);

		doReturn(new ArrayList<Customer>()).when(customerDao).findByDocumentId("DocumentId");
		doReturn(expectedCustomer).when(customerDao).save(any(Customer.class));

		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			customerService.save(customer);
		});
	}

	@Test
	void testSave_005() throws BusinessException {
		Customer customer = new Customer();
		customer.setName("Name");
		customer.setDocumentId("DocumentId");
		customer.setAge(1);

		Address address = new Address();
		address.setId(1l);
		address.setZipCode("99999-999");

		List<Address> addresses = new ArrayList<>();
//		addresses.add(address);
		customer.setAddresses(addresses);

		Customer expectedCustomer = new Customer();
		expectedCustomer.setId(1l);
		expectedCustomer.setName("Name");
		expectedCustomer.setDocumentId("DocumentId");
		expectedCustomer.setAge(1);

		doReturn(new ArrayList<Customer>()).when(customerDao).findByDocumentId("DocumentId");
		doReturn(expectedCustomer).when(customerDao).save(any(Customer.class));

		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			customerService.save(customer);
		});
	}

	@Test
	void testSave_006() throws BusinessException {
		Customer customer = new Customer();
		customer.setName("Name");
		customer.setDocumentId("DocumentId");
		customer.setAge(1);

		Address address = new Address();
		address.setId(1l);
		address.setZipCode("99a999-999");

		List<Address> addresses = new ArrayList<>();
		addresses.add(address);
		customer.setAddresses(addresses);

		Customer expectedCustomer = new Customer();
		expectedCustomer.setId(1l);
		expectedCustomer.setName("Name");
		expectedCustomer.setDocumentId("DocumentId");
		expectedCustomer.setAge(1);

		doReturn(new ArrayList<Customer>()).when(customerDao).findByDocumentId("DocumentId");
		doReturn(expectedCustomer).when(customerDao).save(any(Customer.class));

		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			customerService.save(customer);
		});
	}
	
	@Test
	void testSave_007() throws BusinessException {
		Customer customer = new Customer();
		customer.setName("Name");
		customer.setDocumentId("DocumentId");
		customer.setAge(1);

		Address address = new Address();
		address.setId(1l);
		address.setZipCode("99999-999");

		List<Address> addresses = new ArrayList<>();
		addresses.add(address);
		customer.setAddresses(addresses);

		Customer expectedCustomer = new Customer();
		expectedCustomer.setId(1l);
		expectedCustomer.setName("Name");
		expectedCustomer.setDocumentId("DocumentId");
		expectedCustomer.setAge(1);

		List<Customer> listCustomers = new ArrayList<Customer>();
		listCustomers.add(new Customer(2l, "DocumentId"));
		doReturn(listCustomers).when(customerDao).findByDocumentId("DocumentId");
		doReturn(expectedCustomer).when(customerDao).save(any(Customer.class));

		Assertions.assertThrows(BusinessException.class, () -> {
			customerService.save(customer);
		});
	}

	@Test
	void testUpdate_001() {
		Customer customer = new Customer();
		customer.setName("Name");
		customer.setDocumentId("DocumentId");
		customer.setAge(1);

		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			customerService.update(null, customer);
		});
	}

	@Test
	void testUpdate_002() throws BusinessException {
		Customer customer = new Customer();
		customer.setName("Name");
		customer.setDocumentId("DocumentId");
		customer.setAge(1);

		Address address = new Address();
		address.setId(1l);
		address.setZipCode("99999-999");

		List<Address> addresses = new ArrayList<>();
		addresses.add(address);
		customer.setAddresses(addresses);

		Customer expectedCustomer = new Customer();
		expectedCustomer.setId(1l);
		expectedCustomer.setName("Name");
		expectedCustomer.setDocumentId("DocumentId");
		expectedCustomer.setAge(1);

		doReturn(new ArrayList<Customer>()).when(customerDao).findByDocumentId("1");
		doReturn(expectedCustomer).when(customerDao).save(any(Customer.class));

		Customer result = customerService.update(1l, customer);

		Assert.notNull(result, "result.null");
	}

	@Test
	void testDelete_001() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			customerService.delete(null);
		});
	}

	@Test
	void testDelete_002() {
		customerService.delete(1l);
	}

}
