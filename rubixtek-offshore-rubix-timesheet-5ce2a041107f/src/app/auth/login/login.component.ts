import { Component, OnInit } from '@angular/core';
import { FormGroup, Validators, FormArray, FormBuilder, FormControl } from '@angular/forms';

import { Router } from '@angular/router';
import { Login } from 'src/app/shared/model/login';
import { MatSnackBar } from '@angular/material/snack-bar';
import { CustomValidators, ValidateAlphaNumeric, ValidateNumber, ValidateNumeric, ValidatePassword } from 'src/app/shared/util';
import { constants, errorMessages } from 'src/app/shared/constants';
import { AuthService } from 'src/app/service/auth/auth.service';
import { environment } from 'src/environments/environment';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss'],

})
export class LoginComponent implements OnInit {
  errors = errorMessages;
  hide = true;
  login = new Login();
  loginForm: FormGroup;
  registerForm: FormGroup;
  constructor(
    private authService: AuthService,
    public snackBar: MatSnackBar,
    private profileService: AuthService,
    private router: Router,
    public fb: FormBuilder) {
      if (this.authService.currentUserValue) { 
        this.router.navigate(['/dashboard']);
    }
     }

  ngOnInit(): void {
    this.loginForm = this.fb.group({
      emailId: ['', [Validators.required,Validators.email]],
      password: ['', [Validators.required]],

    });
    this.registerForm = this.fb.group({

      rcpassword: ['', [Validators.required]],
      emailId: ['', [Validators.required, Validators.email]],
      mobileno: ['', [Validators.required, ValidateNumber]],
      password: ['', [Validators.required, ValidatePassword]],
    }, { validators: CustomValidators.passwordMatchValidator });

  }
  emailExist: String;
  email: any;
  emailToken: Boolean;
 
  public checkError = (controlName: string, errorName: string) => {
    return this.loginForm.controls[controlName].hasError(errorName);
  }
  get addressArray() {
    return <FormArray>this.registerForm.get('addresses');
  }
 
  errorMessage(controlName: string, Name: string): string {
    const form: FormControl = (this.registerForm.get(controlName) as FormControl);
    return form.hasError('required') ?
      Name + this.errors.required  :
      form.hasError('NoPassswordMatch') ?
        this.errors.confirmpassword :
        form.hasError('email') ?
          this.errors.valid + Name :
          form.hasError('EmailExist') ?
            this.errors.emailexist :
            form.hasError('invalidNumber') ?
              this.errors.valid + Name :
              form.hasError('invalidPassword') ?
                this.errors.valid + Name : '';
  }
 
  loginUser() {
    console.log(this.loginForm.value);
    this.authService.login(this.login).subscribe(
      data => {
        this.router.navigate(['/dashboard']);
      },
      (error: Response) => {
        this.profileService.loginServerErrorMessages(error);
      }
    )
  }
  message() {
    this.snackBar.open(constants.PasswordShouldContainOneSpecialCharacter, ' ', {
      duration: 5000,

    });
  }
  register() {
    console.log(this.registerForm.value);
    this.authService.Signup(this.registerForm.value)
      .subscribe(data => {
        console.log(data);
        this.snackBar.open(constants.SignUpSuccessfullyDone, ' ', {
          duration: 3000,
        });
      }, 
      (error: Response) => {
        this.profileService.ServerErrorMessage(error);
      }
      );
  }

}


