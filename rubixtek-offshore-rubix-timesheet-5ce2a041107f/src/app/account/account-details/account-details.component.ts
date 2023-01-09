import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/service/auth/auth.service';
import { EmployeeService } from 'src/app/service/employee/employee.service';
import { ValidateNumber, ValidatePassword } from 'src/app/shared/util';
import {STEPPER_GLOBAL_OPTIONS} from '@angular/cdk/stepper';
@Component({
  selector: 'app-account-details',
  templateUrl: './account-details.component.html',
  styleUrls: ['./account-details.component.scss'],
  providers: [{
    provide: STEPPER_GLOBAL_OPTIONS, useValue: {displayDefaultIndicatorType: false}
  }]
})
export class AccountDetailsComponent implements OnInit {
userForm:FormGroup;
documentForm:FormGroup;
firstFormGroup:FormGroup;
secondFormGroup:FormGroup;

employee:any;
id:any;
editPersonal:Boolean=false;
  constructor(private authService: AuthService,
    public snackBar: MatSnackBar,
    private employeeService: EmployeeService,
    private router: Router,
    public fb: FormBuilder) { }

  ngOnInit(): void {
    this.id=this.authService.userDetail.id;
    this.userForm = this.fb.group({
      firstname: ['', [Validators.required]],
      lastname: ['', [Validators.required, ]],
      mobileno: ['', [Validators.required, ValidateNumber]],
      emailId:['',[Validators.required,Validators.email]],
      address:['',[Validators.required]]
    });
    this.documentForm=this.fb.group({
     
      accountNo:[''],
      ifscCode:[''],
      pancardNo:[''],

    })
    this.firstFormGroup = this.fb.group({
      firstCtrl: ['', Validators.required]
    });
    this.secondFormGroup = this.fb.group({
      secondCtrl: ['', Validators.required]
    });
    this.getUserDetail();
  }
  getUserDetail(){
    this.employeeService.getEmpById(this.id).subscribe(data=>{
      this.userForm.patchValue(data);
      this.employee=data;
      console.log(data)});
  }
  onSubmit(){
    
  }

}
