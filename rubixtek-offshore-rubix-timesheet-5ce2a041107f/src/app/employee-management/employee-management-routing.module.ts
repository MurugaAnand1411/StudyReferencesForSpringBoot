import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LayoutComponent } from '../shared/navigation-contents/layout/layout.component';
import { EmployeeListComponent } from './employee-list/employee-list.component';
import { UpdateEmployeeComponent } from './update-employee/update-employee.component';
import { PayslipComponent } from './payslip/payslip/payslip.component';
import { AddEmployeeComponent } from './add-employee/add-employee.component';
const routes: Routes = [
  {
    path: '',
    component: LayoutComponent,
    children: [
      { path: 'employees/info', component: EmployeeListComponent},
    ]
  },
  {
    path: '',
    component: LayoutComponent,
    children: [
      { path: 'payslip', component: PayslipComponent},
    ]
  },
  {
    path: '',
    component: LayoutComponent,
    children: [
      { path: 'add-employee', component: AddEmployeeComponent},
    ]
  },
  {
    path: '',
    component: LayoutComponent,
    children: [
      { path: 'employees/data/:empId', component: UpdateEmployeeComponent},
    ]
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class EmployeeManagementRoutingModule { }
