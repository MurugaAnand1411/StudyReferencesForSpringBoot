import { HttpHeaders } from '@angular/common/http';
import { MatSnackBar } from '@angular/material/snack-bar';
import { constants } from 'src/app/shared/constants';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { User } from './../../shared/model/user';
import { environment } from './../../../environments/environment';


@Injectable({ providedIn: 'root' })
export class AuthService {
  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };
  apiUrl = environment.apiUrl;
  private _userDetail: User[];
  private userlogin = this.apiUrl + '/timesheet/auth/signin';
  private register = this.apiUrl + '/timesheet/auth/signup';

  private currentUserSubject: BehaviorSubject<User>;
  public currentUser: Observable<User>;
  private currentRoleSubject: BehaviorSubject<any>;
  public currentRole: Observable<any>;

  constructor(private http: HttpClient,
    public snackBar: MatSnackBar) {
    this.currentUserSubject = new BehaviorSubject<User>(JSON.parse(localStorage.getItem('currentUser')));
    this.currentUser = this.currentUserSubject.asObservable();
    this.currentRoleSubject = new BehaviorSubject<any>(JSON.parse(localStorage.getItem('Roles')));
    this.currentRole = this.currentRoleSubject.asObservable();
  }

  public get currentUserValue(): User {
    return this.currentUserSubject.value;
  }
  public getIsLogged(): boolean {
    if(this.currentUserSubject.value!=null)
    return true;
  }
  public get IsEmployee(): boolean {
    if(this.currentRoleSubject.value=='ROLE_EMPLOYEE'){
    return true;
    }else{
      return false;
    }
  }
  public get IsAdmin(): boolean {
    if(this.currentRoleSubject.value=='ROLE_TL'|| this.currentRoleSubject.value=='ROLE_ADMIN'){
    return true;
    }else{
      return false;
    }
  }
  public get IsTimesheetApprover(): boolean {
    if(this.currentRoleSubject.value=='ROLE_TA'){
    return true;
    }else{
      return false;
    }
  }
  login(login: object) {
    return this.http.post<any>(`${this.userlogin}`, login, this.httpOptions)
      .pipe(map(user => {
        // store user details and jwt token in local storage to keep user logged in between page refreshes
        localStorage.setItem('currentUser', JSON.stringify(user));
        localStorage.setItem('Roles', JSON.stringify(user.roles));
        this.currentUserSubject.next(user);
        this.currentRoleSubject.next(user.roles);
        return user;
      }));
  }

  logout() {
    // remove user from local storage to log user out
    localStorage.removeItem('currentUser');
    this.currentUserSubject.next(null);
  }
  Signup(signup: object): Observable<any> {

    return this.http.post(`${this.register}`, signup,{responseType:'text'});
  }
  loginServerErrorMessages(error: Response) {
    if (error.status === 400) {
      this.snackBar.open(constants.PleaseEnterValidEmailidAndPassword, ' ', {
        duration: 3000,

      });
      console.log(error);
    }
    else if (error.status === 422) {

      this.snackBar.open(constants.InvalidCredentialsPleaseEnterValidEmailidAndPassword, ' ', {
        duration: 3000,

      });
      console.log(error);
    }
  }

  ServerErrorMessage(error: Response) {
    if (error.status === 200) {

      this.snackBar.open(constants.SignUpSuccessfullyDone, ' ', {
        duration: 3000,

      });
      console.log(error);
    }
    else if (error.status === 400) {

      this.snackBar.open(constants.ErrorOccurInClientside, ' ', {
        duration: 2000,

      });
      console.log(error);
    }
    else if (error.status === 500) {

      this.snackBar.open(constants.ServerSideError, ' ', {
        duration: 2000,

      });
      console.log(error);
    }
    else {


      this.snackBar.open(constants.AnUnexceptedErrorOccured, ' ', {
        duration: 2000,

      });
      console.log(error);
    }
  }
  get userDetail() { 
    return <User>(
      JSON.parse(localStorage.getItem("currentUser" ))
    );
  }
  set userDetail(detail:User) {
    this._userDetail.push(detail);
  }
}

