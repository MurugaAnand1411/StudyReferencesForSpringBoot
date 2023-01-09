export class Employee {
    firstname: String;
    lastname: String;
    mobileno: string;
    emailId:String;
    password:String;
    bloodgroup:String;
    dateOfBirth:String;
    status:String;
    bank:BankDetails;
    official:Official;
    address:Address[];
    supervisor:Supervisor;
    roles:Roles[];
}
export class Roles{
    id:number;
    name:String;
}
export class BankDetails{
    bankdetailsId:String;
    bankName:String;
    branchName:String;
    accountNo: String;
    ifscCode: String;
    pancardNo: String;
    adhaarNo: String
}
export class Official{
    officialId:String;
    DOJ: String;
    salary: String;
    designation:String;
}
export class Address{
    addressId: String;
    address: String;
    city: String;
    state: String;
    zipCode: String;
}
export class Salary{
    basic:Number;
    hra:Number;
    dearnessAllowance:Number;
    travelAllowance:Number;
    medicalAllowance:Number;
    providentFund:Number;
    grossPay:Number;
    netPay:String;
}

export class Supervisor{
    employeeId:String;
    firstname:String
}