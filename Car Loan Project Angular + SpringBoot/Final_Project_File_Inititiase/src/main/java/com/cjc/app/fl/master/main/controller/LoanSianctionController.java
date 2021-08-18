package com.cjc.app.fl.master.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cjc.app.fl.master.main.model.Loan_Details;
import com.cjc.app.fl.master.main.serviceinf.FIleInitialiserInf;
import com.cjc.app.fl.master.main.serviceinf.LoanSianctionInf;

@RestController
@CrossOrigin("*")
@RequestMapping("/file")
public class LoanSianctionController {
	
	@Autowired
	FIleInitialiserInf fi;
	
	@Autowired
	LoanSianctionInf li;
	
//	@Autowired
//  public JavaMailSender jms;
	
	// To get all Loan Amount Calculations by Customer Id 
	@GetMapping("/finalsettlement/{cid}")
	public Loan_Details getloan(@PathVariable("cid") int cid ) {
		return li.getloan(cid);
	}
	
//	@GetMapping("/send")
//	public String sendmail() {
//		
//		SimpleMailMessage m=new SimpleMailMessage();
//		m.setTo("");
//		m.setSubject("Hello");
//		m.setText("How are You?");
//		jms.send(m);
//		return "Sent";
//	}
	
}
