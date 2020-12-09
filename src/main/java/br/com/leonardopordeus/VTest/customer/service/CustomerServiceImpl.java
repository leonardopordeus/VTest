package br.com.leonardopordeus.VTest.customer.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import br.com.leonardopordeus.VTest.BusinessException;
import br.com.leonardopordeus.VTest.customer.dao.CustomerDao;
import br.com.leonardopordeus.VTest.customer.entity.Address;
import br.com.leonardopordeus.VTest.customer.entity.Customer;
import br.com.leonardopordeus.VTest.customer.filter.CustomerFilter;

/**
 * Service for CRUD operations of Customer entity;
 * @author leonardo.pordeus
 *
 */
@Service
public class CustomerServiceImpl implements CustomerService {
	
	CustomerDao customerDao;

	public CustomerServiceImpl(CustomerDao customerDao) {
		super();
		this.customerDao = customerDao;
	}

	@Override
	public Customer get(Long id) throws BusinessException {
		
		Assert.notNull(id, "br.com.leonardopordeus.vtest.customer.id.null");
		
		Optional<Customer> result = this.customerDao.findById(id);

		if(!result.isPresent()) {
			throw new BusinessException("br.com.leonardopordeus.vtest.customer.noresult");
		}
		return result.get();
	}

	@Override
	public Customer save(Customer customer) throws BusinessException {

		//Not Null Validations
		Assert.notNull(customer.getDocumentId(), "br.com.leonardopordeus.vtest.customer.documentid.null");
		Assert.notNull(customer.getName(), "br.com.leonardopordeus.vtest.customer.name.null");
		Assert.notEmpty(customer.getAddresses(), "br.com.leonardopordeus.vtest.customer.address.null");
		
		//Address Validations
		for (Address address : customer.getAddresses()) {
			Assert.notNull(address.getZipCode(), "br.com.leonardopordeus.vtest.address.zipcode.null");
			Assert.isTrue(address.getZipCode().matches("^\\d{5}-\\d{3}$"), "br.com.leonardopordeus.vtest.address.zipcode.invalid.format");
		}
		
		if(customer.getRegistrationDate() == null) {
			customer.setRegistrationDate(new Date());			
		}
		customer.setLastUpdate(new Date());
		
		//Unique Validation
		List<Customer> listCostumers = this.customerDao.findByDocumentId(customer.getDocumentId());
		if(listCostumers != null && !listCostumers.isEmpty())
		{
			for (Customer c : listCostumers) {
				if(customer.getId() != null 
						&& !customer.getId().equals(c.getId())
						&& customer.getDocumentId().equals(c.getDocumentId())) {
					throw new BusinessException("br.com.leonardopordeus.vtest.customer.documentid.non.unique");
				} else if(customer.getId() == null 
						&& customer.getDocumentId().equals(c.getDocumentId())) {
					throw new BusinessException("br.com.leonardopordeus.vtest.customer.documentid.non.unique");
				}
			}
		}
		
		customer = this.customerDao.save(customer);
		return customer;
	}

	@Override
	public Customer update(Long id, Customer customer) throws BusinessException {
		Assert.notNull(id, "br.com.leonardopordeus.vtest.customer.id.null");
		customer.setId(id);
		return this.save(customer);
	}

	@Override
	public void delete(Long id) {
		Assert.notNull(id, "br.com.leonardopordeus.vtest.customer.id.null");
		this.customerDao.deleteById(id);
	}

	@Override
	public List<Customer> list(CustomerFilter customerFilter) {
		return this.customerDao.findCustomerByFilter(customerFilter);
	}

}
