package br.com.leonardopordeus.VTest.customer.resource;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.leonardopordeus.VTest.BusinessException;
import br.com.leonardopordeus.VTest.customer.dto.CustomerDto;
import br.com.leonardopordeus.VTest.customer.entity.Customer;
import br.com.leonardopordeus.VTest.customer.filter.CustomerFilter;
import br.com.leonardopordeus.VTest.customer.service.CustomerService;

@RestController
@RequestMapping("api/customer")
public class CustomerResource {

	CustomerService customerService;
	ModelMapper modelMapper;

	public CustomerResource(CustomerService customerService) {
		super();
		this.customerService = customerService;
		modelMapper = new ModelMapper();
	}
	
	@GetMapping(value = "/{id}", produces = "application/json")
	public CustomerDto get(@PathVariable("id") Long id) throws BusinessException {
		Customer customer = this.customerService.get(id);
		CustomerDto customerDto = modelMapper.map(customer, CustomerDto.class);
		return customerDto;
	}
	
	@PostMapping(value = "/", produces = "application/json")
	public CustomerDto save(@RequestBody CustomerDto customerDto) throws BusinessException {
		Customer customer = modelMapper.map(customerDto, Customer.class);
		customer = this.customerService.save(customer);
		customerDto = modelMapper.map(customer, CustomerDto.class);
		return customerDto;
	}
	
	@PutMapping(value = "/{id}", produces = "application/json")
	public CustomerDto update(@PathVariable("id") Long id, @RequestBody CustomerDto customerDto) throws BusinessException {
		Customer customer = modelMapper.map(customerDto, Customer.class);
		customer = this.customerService.update(id,customer);
		customerDto = modelMapper.map(customer, CustomerDto.class);
		return customerDto;
	}
	
	@DeleteMapping(value = "/{id}", produces = "application/json")
	public void delete(@PathVariable("id") Long id) {
		this.customerService.delete(id);
	}
	
	@PostMapping(value = "/list")
	public List<CustomerDto> list(@RequestBody CustomerFilter customerFilter) {
		List<Customer> result = this.customerService.list(customerFilter);
		ModelMapper modelMapper = new ModelMapper();
		List<CustomerDto> resultDTO = result.stream()
				.map(source -> modelMapper.map(source, CustomerDto.class)).collect(Collectors.toList());
		return resultDTO;
	}
	
}
