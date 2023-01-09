import {TokenStorageService} from 'src/app/service/token-storage.service';
import { SidebarService } from '../service/sidebar.service';


import { Component, OnInit, ChangeDetectorRef, OnDestroy, AfterViewInit } from '@angular/core';
import { CommonModule } from "@angular/common";
import { sideNavigationMenu } from '../../constants';
import { MediaMatcher } from '@angular/cdk/layout';
import { Subscription } from 'rxjs';

import { Router } from '@angular/router';
@Component({
  selector: 'app-top-navigation',
  templateUrl: './top-navigation.component.html',
  styleUrls: ['./top-navigation.component.css']
})
export class TopNavigationComponent implements OnInit, OnDestroy, AfterViewInit {

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
    constructor(public  tokenStorageService: TokenStorageService,private _sideBarService: SidebarService,
         private router: Router,
         private changeDetectorRef: ChangeDetectorRef,
        private media: MediaMatcher) {
        this.mobileQuery = this.media.matchMedia('(max-width: 1000px)');
        this._mobileQueryListener = () => changeDetectorRef.detectChanges();
        // tslint:disable-next-line: deprecation
        this.mobileQuery.addListener(this._mobileQueryListener);
    }

    ngOnInit(): void {
     
    }
    toggleSidebar() {
          this._sideBarService.toggle();
        }
    ngOnDestroy(): void {
        // tslint:disable-next-line: deprecation
        this.mobileQuery.removeListener(this._mobileQueryListener);
    }

    ngAfterViewInit(): void {
        this.changeDetectorRef.detectChanges();
    }

    callSignOut(){
        // this.authService.logout();
        this.router.navigate(['']);
    }
    
    
     
  
}