package br.com.leonardopordeus.VTest.customer.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.leonardopordeus.VTest.customer.entity.Customer;
import br.com.leonardopordeus.VTest.customer.filter.CustomerFilter;

@Repository
public interface CustomerDao extends CrudRepository<Customer, Long>{

	@Query("SELECT DISTINCT c FROM Customer c "
			+ " JOIN c.addresses a "
			+ " WHERE "
			+ "    (:#{#filter.documentId}  IS NULL OR c.documentId LIKE %:#{#filter.documentId}%) "
			+ "AND ( :#{#filter.name} 	 IS NULL OR c.name LIKE %:#{#filter.name}%) "
			+ "AND ( :#{#filter.zipCode} IS NULL OR a.zipCode LIKE %:#{#filter.zipCode}%) "
			)
	List<Customer> findCustomerByFilter(@Param("filter") CustomerFilter filter);
	
	List<Customer> findByDocumentId(String documentId);
	
}
