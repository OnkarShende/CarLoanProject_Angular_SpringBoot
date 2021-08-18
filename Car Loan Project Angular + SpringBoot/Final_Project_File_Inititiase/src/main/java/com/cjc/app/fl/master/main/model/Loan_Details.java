package com.cjc.app.fl.master.main.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Loan_Details {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int lid;
	private int lcode;
	private int cid;
	private String cname;
	private String caddress;
	private String cemailid;
	private long cmobileno;
	private int loanAmount;
	private double roi;
	private int tenure;
	private int downPayment;
	private int processingFee;
	private int annualIncome;
	private double totalInterest;
	private double emi;

}
