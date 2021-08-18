package com.cjc.app.fl.master.main.serviceimpl;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cjc.app.fl.master.main.dao.DocumentRepository;
import com.cjc.app.fl.master.main.dao.FIleInitialiserRepository;
import com.cjc.app.fl.master.main.model.Customer_Details;
import com.cjc.app.fl.master.main.model.Document;
import com.cjc.app.fl.master.main.serviceinf.FIleInitialiserInf;

@Service
public class FIleInitialiserImpl implements FIleInitialiserInf {

	@Autowired
	FIleInitialiserRepository fr;
	
	@Autowired
	DocumentRepository dr;
	
	@Override
	public Customer_Details save(Customer_Details cd) {
			return fr.save(cd);
	}

	@Override
	public List<Customer_Details> getalldata() {
		return fr.findAll();
	}

	@Override
	public Customer_Details getcustomer(int cid) {
		return fr.findByCid(cid);
	}

	@Override
	public String savedocument(Document d) {
		String message="";
		List<Customer_Details> clist =fr.findAll();
		for (Customer_Details cd : clist) {
			
			if(d.getCemail().equals(cd.getCemail())) {
				d.setCid(cd.getCid());
				dr.save(d);
				message="Your Documents Saved Succussfully!";
			}
			else {
				message="Documents are not Saved, Please Provide Correct Email Id ";
			}
		}
		return message;
	}

	@Override
	public Document getdocsyid(int cid) {
		return dr.findByCid(cid);
	}

	@Transactional
	@Override
	public void deleteuser(int cid) {
		fr.deleteById(cid);
		dr.deleteById(cid);
	}

	@Override
	public Customer_Details getsingle(int cid) {
		return fr.findByCid(cid);
	}

	@Override
	public void changestatus(int cid) {
	 Customer_Details cd=fr.findByCid(cid);
	 if(cd.getCid()==cid) {
		 cd.setVerifystatus("Varified");
		 fr.save(cd);
	 }
	 else {
		 System.out.println("Wronge Id");
	 }
		 	
	}
}
