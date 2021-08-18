import { Component, OnInit } from '@angular/core';
import { CustomerDetails } from 'app/model/customer-details';
import { PreviousLoanDetails } from 'app/model/previous-loan-details';
import { CityServiceService } from 'app/module/shared/city-service.service';
import { data } from 'jquery';


@Component({
  selector: 'app-filedashboard',
  templateUrl: './filedashboard.component.html',
  styleUrls: ['./filedashboard.component.css']
})
export class FiledashboardComponent implements OnInit {

  constructor(private common:CityServiceService) { }
 
  p:number=1;
  count:number=5;
  totallenght:number
  customerlist:CustomerDetails[];
  customerobject:CustomerDetails;
  previousloan:PreviousLoanDetails[];
  documentobject:Document;
  ngOnInit(): void {
      this.common.getusers().subscribe(data=>{
      this.customerlist=data;
      this.totallenght=data.length;  
    })
  }

  deletedata(cid:number) {
      this.common.deletecustomer(cid).subscribe();
      window.location.reload();
  }

  table1:boolean=true; 
  table2:boolean=false;
  showdata(cid:number) {
    this.table1=false; 
    this.table2=true;
    this.common.getsingleuser(cid).subscribe(data=>{
    this.customerobject=data;
  })
}
  
showdoc(cid:number) { 
  this.common.getsingleuserdoc(cid).subscribe((data:Document)=>
  this.documentobject=data);
}

back() {
  window.location.reload() 
 }

}