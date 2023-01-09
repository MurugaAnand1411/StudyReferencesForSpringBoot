import { OnInit } from '@angular/core';
import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from './service/auth/auth.service';
import { TokenStorageService } from './service/token-storage.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {
  title = 'timesheet';
  private roles: string[];
  isLoggedIn = false;
  currentUser=false
  showEmployee=false;
  showAdminBoard = false;
  showHRBoard = false;
  username: string;
  constructor(private tokenStorageService: AuthService,private router: Router,) { 
    if(this.tokenStorageService.currentUserValue){
this.currentUser
    }
  }
  ngOnInit(): void {

  // this.isLoggedIn = !!this.tokenStorageService.getToken();

  //   if (this.isLoggedIn) {
  //     const user = this.tokenStorageService.getUser();
  //     this.roles = user.roles;

  //     this.showEmployee = this.roles.includes('ROLE_EMPLOYEE');
  //     this.showAdminBoard = this.roles.includes('ROLE_ADMIN');
  //     this.showHRBoard = this.roles.includes('ROLE_HR');

  //     this.username = user.username;
  //   }
  }

  logout(): void {
    this.tokenStorageService.logout();
    this.router.navigate([''])
    window.location.reload();
  }
}
