import { NgModule,CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AccountRoutingModule } from './account-routing.module';
import { AccountDetailsComponent } from './account-details/account-details.component';
import { SharedModule } from '../shared/shared.module';


@NgModule({
  declarations: [AccountDetailsComponent],
  imports: [
    CommonModule,
    AccountRoutingModule,
    SharedModule
  ],
  schemas:[CUSTOM_ELEMENTS_SCHEMA]
})
export class AccountModule { }
