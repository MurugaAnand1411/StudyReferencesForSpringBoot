import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators, FormArray } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRoute, Router } from '@angular/router';
import { TeamLeadService } from 'src/app/service/admin/team-lead.service';
import { AuthService } from 'src/app/service/auth/auth.service';
import { EmployeeService } from 'src/app/service/employee/employee.service';
import { ValidateAlphaNumeric, ValidateNumber, ValidateNumeric } from 'src/app/shared/util';
import { formatDate } from '@angular/common';
import { Employee, Supervisor } from 'src/app/shared/model/employee';
import { parse } from 'date-fns';
@Component({
  selector: 'app-update-employee',
  templateUrl: './update-employee.component.html',
  styleUrls: ['./update-employee.component.scss']
})
export class UpdateEmployeeComponent implements OnInit {
  supervisor:Supervisor[];
  employeeId: any;
  employee: Employee=new Employee();
  userForm: FormGroup;
  qualificationForm: FormGroup;
  officialForm: FormGroup;
  documentForm: FormGroup;
  id: any;
  editPersonal: Boolean = false;
  addressId: any;
  dateb:any;
  datej:any;
  selectSupervisor:String;
  editSupervisor:Boolean=false;
  editRoles: boolean;
  selectRoles: any;
  constructor(private authService: AuthService,
    public snackBar: MatSnackBar,
    private teamleadService: TeamLeadService,
    private employeeService: EmployeeService,
    private router: Router, private route: ActivatedRoute,
    public fb: FormBuilder) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['empId'];
    this.userForm = this.fb.group({
      firstname: ['', [Validators.required]],
      lastname: ['', [Validators.required,]],
      mobileno: ['', [Validators.required, ValidateNumber]],
      emailId: ['', [Validators.required, Validators.email]],
      bloodgroup: [''],
      dateOfBirth: [''],
      address: this.fb.array([this.addressgroup()])
    });
    this.documentForm = this.fb.group({
      bankdetailsId:[''],
      bankName: ['aaaaaaaaaaaa'],
      branchName: ['aaaaa'],
      accountNo: ['2133333'],
      ifscCode: ['qqqqqqqqq'],
      pancardNo: ['qqqqqqqq'],
      adhaarNo: ['qqqqqqqqqq']
    })
    this.officialForm = this.fb.group({
      officialId:[''],
      DOJ: [''],
      salary: ['1222222'],
      designation: ['saaaaaaaaa']
    })
    this.getUserDetail();
    this.getDetailsById();
    this.getAdmin();
  }
  changeMode(){
    this.editSupervisor=!this.editSupervisor;
  }
  saveMode(){
    
    this.teamleadService.editSupervisor(this.id,this.selectSupervisor,this.employee).subscribe(data=>{
      console.log(data);
      this.editSupervisor=false;
    },err=>{
      console.log(err);
      this.editSupervisor=false;
    })
  }
  roles=["Admin","TL","Employee","TimesheetApprover"]
  changeRolesMode(){
    this.editRoles=!this.editRoles;
  }
  saveRolesMode(){
    
    this.teamleadService.editRoles(this.id,this.selectRoles,this.employee).subscribe(data=>{
      console.log(data);
      this.editRoles=false;
    },err=>{
      console.log(err);
      this.editRoles=false;
    })
  }
  getUserDetail() {
    this.employeeService.getEmpById(this.id).subscribe(data => {
      this.userForm.patchValue(data);
      this.employee = data;
      this.userForm.patchValue(this.employee);
      this.documentForm.patchValue(this.employee.bank);
      this.officialForm.patchValue(this.employee.official);
      this.dateb=this.employee.dateOfBirth;
      console.log(this.dateb);
      this.dateb= parse(this.dateb, 'dd/MM/yyyy', new Date());
      console.log(this.dateb);
      this.datej=this.employee.official.DOJ;
      this.datej=new Date(Number(Date.parse(this.datej)));
    

      console.log(data)
    });
  }
  onSubmit() {

  }
  getDetailsById() {
    this.employeeService.getEmpById(this.id).subscribe(data => { this.employee = data; console.log(data); })
  }
  getAdmin() {
    this.teamleadService.getAllAdmins().subscribe(data => {this.supervisor=data; this.selectSupervisor=this.supervisor[0].employeeId; console.log(this.supervisor) });
  }
  get addressArray() {
    return <FormArray>this.userForm.get('address');
  }
  addressgroup() {
    return this.fb.group({
      addressId: [''],
      address: ['', [Validators.required, ValidateAlphaNumeric]],
      city: ['', [Validators.required, ValidateAlphaNumeric]],
      state: ['', [Validators.required, ValidateAlphaNumeric]],
      zipCode: ['', [Validators.required, ValidateNumeric]]

    });
  }
  addaddresstype() {
    this.addressArray.push(this.addressgroup());
  }

  removeaddresstype(index: number) {
    this.addressId = this.addressArray.at(index).value.addressId;
    console.log(this.addressId);
    this.addressArray.removeAt(index);
  }
  updateEmployee(){
    this.employee=this.userForm.value;
    this.employee.dateOfBirth=formatDate(this.userForm.controls['dateOfBirth'].value,'dd/MM/yyyy','en-GB');
    this.employee.bank=this.documentForm.value;
    this.employee.official=this.officialForm.value;
    this.employee.official.DOJ=formatDate(this.officialForm.controls['DOJ'].value,'dd/MM/yyyy','en-GB');
    console.log(this.employee);
    this.teamleadService.editEmployee(this.id,this.employee).subscribe(
      (data)=>{console.log(data)},
      err=>{
      console.log(err);
    })
    
  }
}