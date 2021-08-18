package com.cjc.app.fl.master.main.serviceinf;

import java.util.List;
import com.cjc.app.fl.master.main.model.Customer_Details;
import com.cjc.app.fl.master.main.model.Document;

public interface FIleInitialiserInf {

	Customer_Details save(Customer_Details cd);
	List<Customer_Details> getalldata();
	Customer_Details getcustomer(int cid);
	String savedocument(Document d);
	Document getdocsyid(int cid);
	void deleteuser(int cid);
	Customer_Details getsingle(int cid);
	void changestatus(int cid);
}
