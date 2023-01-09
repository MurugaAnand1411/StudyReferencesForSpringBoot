import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {SharedModule} from '../shared/shared.module';
import { DashboardRoutingModule } from './dashboard-routing.module';
import { HomeComponent } from './home/home.component';
import { AdminAuthGuard } from '../shared/guards/admin.guard';


@NgModule({
  declarations: [HomeComponent],
  imports: [
    CommonModule,
    SharedModule,
    DashboardRoutingModule
  ],
  providers: [ AdminAuthGuard]
})
export class DashboardModule { }
