package br.com.leonardopordeus.VTest.customer.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.leonardopordeus.VTest.customer.entity.Address;

@Repository
public interface AddressDao extends CrudRepository<Address, Long>{

}
