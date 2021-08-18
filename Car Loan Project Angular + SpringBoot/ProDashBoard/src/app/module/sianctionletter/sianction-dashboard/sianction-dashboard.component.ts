import { Component, OnInit } from '@angular/core';
import { CustomerDetails } from 'app/model/customer-details';
import { LoanDetails } from 'app/model/loan-details';
import { PreviousLoanDetails } from 'app/model/previous-loan-details';
import { CityServiceService } from 'app/module/shared/city-service.service';
import html2canvas from 'html2canvas';
import jsPDF from 'jspdf';

@Component({
  selector: 'app-sianction-dashboard',
  templateUrl: './sianction-dashboard.component.html',
  styleUrls: ['./sianction-dashboard.component.css']
})
export class SianctionDashboardComponent implements OnInit {

  constructor(private common:CityServiceService) { }

  todaydate=new Date();
  customerlist:CustomerDetails[];
  customerobject:CustomerDetails;
  previousloan:PreviousLoanDetails[];
  documentobject:Document;
  loandetailsobject:LoanDetails;

  sanctionstatus:string="Proceed to Sanction";
  ngOnInit(): void {
    this.table1=true;
    this.table2=false;
    this.table3=false;
    this.table4=false;
    this.common.getusers().subscribe(data=>{
    this.customerlist=data;
    })   
  }

  table1:boolean; 
  table2:boolean;
  table3:boolean;
  table4:boolean;

  verify(cid:number) {
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

  verified(cid:number) {
    this.table1=true;
    this.table2=false;
    this.table3=false;
    this.table4=false;
    this.common.changeverifystatus(cid).subscribe(); 
    window.location.reload();
   }

  sanction(cid:any) {
    this.table1=false;
    this.table2=false;
    this.table3=true;
    this.table4=false;
    this.sanctionstatus="Sanctioned";
    this.common.getloandetails(cid).subscribe(data=>{
    this.loandetailsobject=data;
  })
}

  sanctionletter(cid:number) {
    this.table1=false;
    this.table2=false;
    this.table3=false;
    this.table4=true;
    console.log(cid);
   }

  generatepdf(divId) {
       let data = document.getElementById('mypdf');  
       html2canvas(data).then(canvas => {
       const contentDataURL = canvas.toDataURL('image/png')  
       let pdf = new jsPDF('l', 'cm', 'a4'); 
       pdf.addImage(contentDataURL, 'PNG', 0, 0, 29.7, 21.0);  
       pdf.save('SianctionLetter.pdf');   
     }); 
   }
}