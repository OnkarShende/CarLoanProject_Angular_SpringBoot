package com.cjc.app.fl.master.main.serviceimpl;

import java.util.List;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cjc.app.fl.master.main.dao.FIleInitialiserRepository;
import com.cjc.app.fl.master.main.dao.LoanSianctionRepository;
import com.cjc.app.fl.master.main.model.Customer_Details;
import com.cjc.app.fl.master.main.model.Loan_Details;
import com.cjc.app.fl.master.main.serviceinf.LoanSianctionInf;

@Service
public class LoanSianctionImpl implements LoanSianctionInf {

	@Autowired
	LoanSianctionRepository lr;
	
	@Autowired
	FIleInitialiserRepository fr;
	
	@Override
	public Loan_Details getloan(int cid) {
		
		Customer_Details cdr=new Customer_Details();
	
		List<Loan_Details> loanlist =lr.findAll();
		
		for (Loan_Details ld1 : loanlist) {
			cdr.setCid(ld1.getCid());
		}
		
		List<Customer_Details> cdlist =fr.findAll();
		Loan_Details ld=new Loan_Details();
		
		for (Customer_Details cd : cdlist) {
			
			if(cid==cd.getCid()) {
				ld.setCid(cd.getCid());
				ld.setCname(cd.getCname());
				ld.setCemailid(cd.getCemail());
				ld.setCaddress(cd.getLocaladdress());
				ld.setCmobileno(cd.getCmobileno());
				ld.setLoanAmount(cd.getRequiredamount());
				ld.setRoi(8);
				ld.setTenure(cd.getTenure());
				ld.setDownPayment(cd.getDownpayment());
				ld.setAnnualIncome(cd.getAnnualincome());
				
				if (ld.getAnnualIncome() >= 500000 && ld.getAnnualIncome() <= 2000000) {
	
				   int maxloanamt = 30000000;
				   if (maxloanamt >= ld.getLoanAmount()) {
						
		    		double principalamt = ld.getLoanAmount();
					double rate =ld.getRoi();
					rate = rate / (12 * 100);
					double tenure = ld.getTenure();

					double emi = (principalamt * rate * Math.pow(1 + rate, tenure)) / (Math.pow(1 + rate, tenure) - 1);
					ld.setEmi(emi);

					double totalinterest = (emi*tenure)-ld.getLoanAmount();
					ld.setTotalInterest(totalinterest);
					
					int processingFee=(int) ((ld.getLoanAmount()*0.3)/100);
					ld.setProcessingFee(processingFee);
				
					Random ra=new Random();
					ld.setLcode(ra.nextInt(4000));
				
					if(cdr.getCid()==ld.getCid()) {
							System.out.println("Already Present");
						}
						else {
							System.out.println("Save");
							lr.save(ld); 
						}
					}
			else {
				System.out.println("your applicabe amt only upto " + maxloanamt);
				
				}
			 }
		   }
		}
		
		return ld;
	}

}
