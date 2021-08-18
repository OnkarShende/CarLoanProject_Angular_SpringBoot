package com.cjc.app.fl.master.main.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Customer_Details {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cid;
	private String cname;
	private long cmobileno;
	private int annualincome;
	private String cemail;
	private int cdependentmember;
	private int downpayment;	
	private String localaddress;
	private String permanentaddress;
	private int requiredamount;
	private int tenure;
	private String verifystatus="Not Verified";
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Previous_Loan> previousloans;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List< Guarandor> guarantors;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Vehicle_Details vehicledetails;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Dealer_Details dealerdetails;
		
}
