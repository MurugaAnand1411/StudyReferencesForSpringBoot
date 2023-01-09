import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router, ActivatedRoute } from '@angular/router';
import { NgxSpinnerService } from 'ngx-spinner';
import { ToastrService } from 'ngx-toastr';
import { TeamLeadService } from 'src/app/service/admin/team-lead.service';
import { EmployeeService } from 'src/app/service/employee/employee.service';
import { constants, errorMessages } from 'src/app/shared/constants';
import { ValidateNumber, ValidatePassword } from 'src/app/shared/util';

@Component({
  selector: 'app-add-employee',
  templateUrl: './add-employee.component.html',
  styleUrls: ['./add-employee.component.scss']
})
export class AddEmployeeComponent implements OnInit {
  userForm: any;
  errors = errorMessages;
  hide = true;
  roles=[{name:"Admin",value:"ROLE_ADMIN"},
  {name:"TL",value:"ROLE_TL"},
  {name:"Employee",value:"ROLE_EMPLOYEE"},
  {name:"TimesheetApprover",value:"ROLE_TA"},
 ];
  selectRoles: any;
  constructor(
    private spinner: NgxSpinnerService,
    private toastr: ToastrService,
    private teamleadService: TeamLeadService,
    private employeeService: EmployeeService,
    private router: Router, private route: ActivatedRoute,
    public fb: FormBuilder
  ) { }

  ngOnInit(): void {
    this.userForm = this.fb.group({
      firstname: ['', [Validators.required]],
      lastname: ['', [Validators.required,]],
      mobileno: ['', [Validators.required, ValidateNumber]],
      emailId: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required, ValidatePassword]],
      roles: this.fb.array([this.rolesgroup()])
    });
  }
  rolesgroup() {
    return this.fb.group({
      id: [''],
      name: ['', [Validators.required]],

    });
  }
  errorMessage(controlName: string, Name: string): string {
    const form: FormControl = (this.userForm.get(controlName) as FormControl);
    return form.hasError('required') ?
      Name + this.errors.required  :
        form.hasError('email') ?
          this.errors.valid + Name :
          form.hasError('EmailExist') ?
            this.errors.emailexist :
            form.hasError('invalidNumber') ?
              this.errors.valid + Name :
              form.hasError('invalidPassword') ?
                "Password should contain one special character, one number,one Upper case,one lower case and minimum length of 8 (Eg:- Rubix@123)" : '';
  }
  onSubmit(){
    this.spinner.show();
    this.teamleadService.addEmployee(this.userForm.value,this.selectRoles).subscribe(data=>{
      console.log(data);
    },err=>{
      this.spinner.hide();
      this.router.navigate(['/admin/employees/info']);
      this.toastr.info('Employee Added');
    });
  }
}
