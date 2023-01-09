import { Component, OnInit, ChangeDetectorRef, OnDestroy, AfterViewInit } from '@angular/core';
import { CommonModule } from "@angular/common";

import { MediaMatcher } from '@angular/cdk/layout';
import { Subscription } from 'rxjs';

import { sideNavigationMenu } from '../../constants';

import { Router } from '@angular/router';
import { AuthService } from 'src/app/service/auth/auth.service';
import { TeamLeadService } from 'src/app/service/admin/team-lead.service';
@Component({
    selector: 'app-layout',
    templateUrl: './layout.component.html',
    styleUrls: ['./layout.component.scss']
})
export class LayoutComponent implements OnInit, OnDestroy, AfterViewInit {

    private _mobileQueryListener: () => void;
    mobileQuery: MediaQueryList;
    showSpinner: boolean;
    userName: string;
    isAdmin: boolean;
    id: number;
    qty:any;
    sessionvalue: any;
    private autoLogoutSubscription: Subscription;
    public sideNavigationItems = sideNavigationMenu;
    isTimesheetApprover: boolean;
    isEmployee: boolean;
    count: any;
    constructor(
        private authService: AuthService,
        private adminService:TeamLeadService,
        private router: Router,
        private changeDetectorRef: ChangeDetectorRef,
        private media: MediaMatcher) {
           
        this.mobileQuery = this.media.matchMedia('(max-width: 1000px)');
        this._mobileQueryListener = () => changeDetectorRef.detectChanges();
        // tslint:disable-next-line: deprecation
        this.mobileQuery.addListener(this._mobileQueryListener);
        if (this.authService.currentUserValue){
            this.userName=this.authService.userDetail.username;
        
        }
            else{
                this.router.navigate([''])
            }
            
            this.isAdmin=this.authService.IsAdmin;
            this.isTimesheetApprover=this.authService.IsTimesheetApprover;
            this.isEmployee=this.authService.IsEmployee;
           
    }
   
    ngOnInit(): void {
        console.log(this.isAdmin);
        if(this.isAdmin || this.isTimesheetApprover){
        this.adminService.getAllPendingCount().subscribe(data=>{
            this.count=data;
            console.log(data);
        });
    }
    }

    ngOnDestroy(): void {
        // tslint:disable-next-line: deprecation
        this.mobileQuery.removeListener(this._mobileQueryListener);
    }

    ngAfterViewInit(): void {
        this.changeDetectorRef.detectChanges();
    }

    callSignOut(){
        this.authService.logout();
        this.router.navigate(['']);
    }
    
    
   
     
  
}