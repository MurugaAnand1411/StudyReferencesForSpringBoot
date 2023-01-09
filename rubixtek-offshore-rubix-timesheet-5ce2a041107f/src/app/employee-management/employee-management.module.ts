import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {SharedModule} from '../shared/shared.module';
import { EmployeeManagementRoutingModule } from './employee-management-routing.module';
import { EmployeeListComponent } from './employee-list/employee-list.component';
import { UpdateEmployeeComponent } from './update-employee/update-employee.component';
import { PayslipComponent } from './payslip/payslip/payslip.component';
import { AddEmployeeComponent } from './add-employee/add-employee.component';


@NgModule({
  declarations: [EmployeeListComponent, UpdateEmployeeComponent, PayslipComponent, AddEmployeeComponent],
  imports: [
    CommonModule,
    SharedModule,
    EmployeeManagementRoutingModule
  ]
})
export class EmployeeManagementModule { }
