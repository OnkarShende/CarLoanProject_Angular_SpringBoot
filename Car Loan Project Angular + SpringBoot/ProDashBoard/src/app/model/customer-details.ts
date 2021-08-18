import { DealerDetails } from "./dealer-details";
import { GuarantorDetails } from "./guarantor-details";
import { PreviousLoanDetails } from "./previous-loan-details";
import { VehicleDetails } from "./vehicle-details";

export class CustomerDetails {

    cid:number;
	cname:string;
	cmobileno:number;
	annualincome:number;
	cemail:string;
	cdependentmember:number;
	downpayment:number;
	localaddress:string;
	permanentaddress:string;
    requiredamount:number;
	tenure:number;
	verifystatus:string;
	vehicledetails:VehicleDetails;
	dealerdetails:DealerDetails;
	previousloans:PreviousLoanDetails;
    guarantors:GuarantorDetails;
	
}
