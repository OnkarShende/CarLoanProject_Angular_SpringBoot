package com.cjc.app.fl.master.main.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cjc.app.fl.master.main.model.Customer_Details;

@Repository
public interface FIleInitialiserRepository extends JpaRepository<Customer_Details, Integer> {
	
	public Customer_Details findByCid(int id);
}
