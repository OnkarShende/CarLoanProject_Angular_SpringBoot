import { Component, OnInit } from '@angular/core';
import { FormArray, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { DocumentDetails } from 'app/model/document-details';
import { CityServiceService } from 'app/module/shared/city-service.service';

@Component({
  selector: 'app-adduser',
  templateUrl: './adduser.component.html',
  styleUrls: ['./adduser.component.css']
})
export class AdduserComponent implements OnInit {

  constructor(private fb:FormBuilder, private common:CityServiceService) { }

  myform1:FormGroup;
  myform2:FormGroup
  ngOnInit(): void {

    this.myform1=this.fb.group({
      cid:[],
      cname:['',[Validators.required]],
      cmobileno:[,[Validators.required]],
      annualincome:[,[Validators.required]],
      cemail:['',[Validators.required]],
      cdependentmember:[,[Validators.required]],
      downpayment:[,[Validators.required]],
      localaddress:['',[Validators.required]],
      permanentaddress:['',[Validators.required]],
      requiredamount:[,[Validators.required]],
      tenure:[,[Validators.required]],

          vehicledetails:this.fb.group({
              vid:[],
              companyname:['',[Validators.required]],
              modelname:['',[Validators.required]],
              colour:['',[Validators.required]],
              onroadprice:[,[Validators.required]]
      }),

          dealerdetails:this.fb.group({
            did:[],
            dealername:['',[Validators.required]],
            dealeraccountno:[,[Validators.required]],
            dealermobileno:[,[Validators.required]],
            email:['',[Validators.required]],
            dealerbank:['',[Validators.required]],
            status:['',[Validators.required]],
          }),
          previousloans:this.fb.array([this.getloan()]),
          guarantors:this.fb.array([this.getgurandor()]),
    })
  }

  getloan(){
    return this.fb.group({
            pid:[],
            loantype:['',[Validators.required]],
            loanamount:[,[Validators.required]],
            remainingloan:[,[Validators.required]],
            tenurepending:[,[Validators.required]],
            previousloanbank:['',[Validators.required]],
    })
  }
  addloan(){
    this.loanArray.push(this.getloan());
  }
  removeloan(index){
    this.loanArray.removeAt(index);
  }
  get loanArray(){
    return <FormArray>this.myform1.get('previousloans')
  }

//-----------------------------------------------------------------------------------------

getgurandor(){
  return this.fb.group({
            guarantorid:[],
            name:['',[Validators.required]],
            mobileno:[,[Validators.required]],
            adharno:[,[Validators.required]],
            occupation:['',[Validators.required]]
  })
}
addgurandor(){
  this.gurandorArray.push(this.getgurandor());
}
removegurandor(index){
  this.gurandorArray.removeAt(index);
}
get gurandorArray(){
  return <FormArray>this.myform1.get('guarantors')
}

  form1:boolean=true; 
  form2:boolean=false; 
  savedata() {
    this.form1=false;
    this.form2=true;
    this.common.savecustomer(this.myform1.value).subscribe();
  }
//-------------------------------------------------------------------------------------------

mydoc=new DocumentDetails();
did:number;
cid:number;
cemail:string;
pancard:any;
adharcard:any;
incomeproof:any;
signature:any;
addressproof:any;
vehiclequatation:any;
photo:any;
itrfile:any;

onSelectedpancard(event:any)  {
  this.pancard=event.target.files[0];
  console.log(this.pancard);
}

onSelectedaadharcard(event:any) {
  this.adharcard=event?.target.files[0];
  console.log(this.adharcard);
}

onSelectedincomeproof(event:any) {
 this.incomeproof=event?.target.files[0];
 console.log(this.incomeproof);
}

onSelectedsignature(event:any) {
  this.signature=event?.target.files[0];
  console.log(this.signature);
}

onSelectedaddressproof(event:any) {
  this.addressproof=event?.target.files[0];
  console.log(this.addressproof);
}
onSelectedvehiclequatation(event:any) {
  this.vehiclequatation=event?.target.files[0];
  console.log(this.vehiclequatation);
}
onSelectedphoto(event:any) {
  this.photo=event?.target.files[0];
  console.log(this.photo);
}
onSelecteditrfile(event:any) {
  this.itrfile=event?.target.files[0];
  console.log(this.itrfile);
}

savedocs() {
  const document1=JSON.stringify(this.mydoc);
  const uploadDocument=new FormData();
  uploadDocument.append('pancard',this.pancard);
  uploadDocument.append('adharcard',this.adharcard);
  uploadDocument.append('incomeproof',this.incomeproof);
  uploadDocument.append('signature',this.signature);
  uploadDocument.append('addressproof',this.addressproof);
  uploadDocument.append('vehiclequatation',this.vehiclequatation);
  uploadDocument.append('photo',this.photo);
  uploadDocument.append('itrfile',this.itrfile);
  uploadDocument.append('doc',document1);
  this.common.savedocs(uploadDocument).subscribe();
  window.location.reload(); 
}

}
