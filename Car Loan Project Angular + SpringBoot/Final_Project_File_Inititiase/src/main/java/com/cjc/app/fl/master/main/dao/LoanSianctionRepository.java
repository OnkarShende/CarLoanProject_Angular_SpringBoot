package com.cjc.app.fl.master.main.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cjc.app.fl.master.main.model.Loan_Details;

@Repository
public interface LoanSianctionRepository extends JpaRepository<Loan_Details, Integer> {

	Loan_Details findByCid(int cid);

}
