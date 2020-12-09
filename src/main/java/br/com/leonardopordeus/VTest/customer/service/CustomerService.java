package br.com.leonardopordeus.VTest.customer.service;

import java.util.List;

import br.com.leonardopordeus.VTest.BusinessException;
import br.com.leonardopordeus.VTest.customer.entity.Customer;
import br.com.leonardopordeus.VTest.customer.filter.CustomerFilter;

public interface CustomerService {

	Customer get(Long id) throws BusinessException;

	Customer save(Customer customer) throws BusinessException;

	Customer update(Long id, Customer customer) throws BusinessException;

	void delete(Long id);

	List<Customer> list(CustomerFilter customerFilter);

}
