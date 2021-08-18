import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { CustomerDetails } from 'app/model/customer-details';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CityServiceService {

  customerurl:string="http://localhost:8080/file";
  deleteurl:string="http://localhost:8080/file/delete";
  getByid_url:string="http://localhost:8080/file/getbyid";
  getBydocid_url:string="http://localhost:8080/file/getdocs";
  getloanBycid_url:string="http://localhost:8080/file/finalsettlement";
  verifystatusurl:string="http://localhost:8080/file/changestatus";

  constructor(private http: HttpClient) { }

  savecustomer(cust:CustomerDetails) {
      return this.http.post(this.customerurl+"/savecustomer",cust);
  }

savedocs(docdata:any):Observable<any> {
  return this.http.post(this.customerurl+"/savedoc",docdata);
}

getusers():Observable<CustomerDetails[]> {
  return this.http.get<CustomerDetails[]> (this.customerurl+"/getall");
}

deletecustomer(cid:number) {
 return this.http.delete(this.deleteurl+"/"+cid);
}

getsingleuser(cid:number):Observable<CustomerDetails> {
return this.http.get<CustomerDetails>(this.getByid_url+"/"+cid);
}

getsingleuserdoc(cid:number) {
return this.http.get(this.getBydocid_url+"/"+cid)
}

changeverifystatus(cid:number) {
  return this.http.put(this.verifystatusurl,cid);
}

getloandetails(cid:number):Observable<any> {
return this.http.get(this.getloanBycid_url+"/"+cid)
}

}
