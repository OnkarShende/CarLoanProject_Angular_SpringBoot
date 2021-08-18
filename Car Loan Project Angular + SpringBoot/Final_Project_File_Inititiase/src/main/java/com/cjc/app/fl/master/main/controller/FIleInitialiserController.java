package com.cjc.app.fl.master.main.controller;

import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.cjc.app.fl.master.main.model.Customer_Details;
import com.cjc.app.fl.master.main.model.Document;
import com.cjc.app.fl.master.main.serviceinf.FIleInitialiserInf;
import com.google.gson.Gson;

@RestController
@CrossOrigin("*")
@RequestMapping("/file")
public class FIleInitialiserController {
	
	@Autowired
	FIleInitialiserInf fi;
	
	// To Save Customer Details
	@PostMapping("/savecustomer")
	public Customer_Details savecustomer(@RequestBody Customer_Details cd ) {
		System.out.println("savedata");
		System.out.println(cd);;
		return fi.save(cd);
	}
	
	// To Save Customer Documents
	@PostMapping(value = "/savedoc", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public String savedata(
								@RequestPart(required = true, value = "pancard") MultipartFile pancardfile,
								@RequestPart(required = true, value = "adharcard") MultipartFile adharcardfile,
								@RequestPart(required = true, value = "incomeproof") MultipartFile incomeprooffile,
								@RequestPart(required = true, value = "signature") MultipartFile signaturefile,
								@RequestPart(required = true, value = "addressproof") MultipartFile addressprooffile,
								@RequestPart(required = true, value = "vehiclequatation") MultipartFile vehiclequatationfile,
								@RequestPart(required = true, value = "photo") MultipartFile photofile,
								@RequestPart(required = true, value = "itrfile") MultipartFile itrfile,
								@RequestPart("doc") String doc
							)  throws IOException
	{
		
	Document d=new Document();	
		d.setPancard(pancardfile.getBytes());
		d.setAdharcard(adharcardfile.getBytes());
		d.setIncomeproof(incomeprooffile.getBytes());
		d.setSignature(signaturefile.getBytes());
		d.setAddressproof(addressprooffile.getBytes());
		d.setVehiclequatation(vehiclequatationfile.getBytes());
		d.setPhoto(photofile.getBytes());
		d.setItrfile(itrfile.getBytes());	

	Gson g=new Gson();
	Document d1 = g.fromJson(doc, Document.class);
	d.setCemail(d1.getCemail());
	System.out.println(d);
	return fi.savedocument(d);
	}
	
	// To get all Customers List
	@GetMapping("/getall")
	public List<Customer_Details> getalldata() {
	return	fi.getalldata();
	}
	
	// To get single Customer by his Id
	@GetMapping("/getbyid/{cid}")
	public Customer_Details getsingle(@PathVariable("cid") int cid)	{
		return	fi.getsingle(cid);
	}
	
	// To Delete Customer by his Id
	@DeleteMapping("/delete/{cid}")
	public void deleteuser(@PathVariable("cid") int cid) {
		System.out.println("Check "+ cid);
		fi.deleteuser(cid);
	}
	
	// To get Customer Documents by his Id
	@GetMapping("/getdocs/{cid}")
	public Document getdocs(@PathVariable("cid") int cid) {
		return fi.getdocsyid(cid);
	}
	
	// To Change Status of Customer Verification
	@PutMapping("/changestatus")
	public void changesattus(@RequestBody int cid) {
		fi.changestatus(cid);
	}
	
}
