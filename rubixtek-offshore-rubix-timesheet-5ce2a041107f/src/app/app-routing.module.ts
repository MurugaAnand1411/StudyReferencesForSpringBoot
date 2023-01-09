import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AdminAuthGuard } from './shared/guards/admin.guard';
import { AuthGuard } from './shared/guards/auth.guard';


const routes: Routes = [
  {
    path: 'timesheet',
    loadChildren: ()=> import('./timesheet/timesheet.module').then(mode=>mode.TimesheetModule),
    canActivate: [AuthGuard]
  },
  {
    path: 'project',
    loadChildren: ()=> import('./project-management/project-management.module').then(mode=>mode.ProjectManagementModule),
    canActivate: [AuthGuard]
  },
  {
    path: 'dashboard',
    loadChildren: ()=> import('./dashboard/dashboard.module').then(mode=>mode.DashboardModule),
    canActivate: [AuthGuard]
  },
  {
    path: '',
    loadChildren: ()=> import('./auth/auth.module').then(mode=>mode.AuthModule),
    canActivate: [AuthGuard]
  },
  {
    path: 'admin',
    loadChildren: ()=> import('./employee-management/employee-management.module').then(mode=>mode.EmployeeManagementModule),
    canActivate: [AuthGuard]
  },
  {
    path: 'timesheet-manage',
    loadChildren: ()=> import('./timesheet-management/timesheet-management.module').then(mode=>mode.TimesheetManagementModule),
    canActivate: [AuthGuard]
  },
  {
    path: 'account',
    loadChildren: ()=> import('./account/account.module').then(mode=>mode.AccountModule),
    canActivate: [AuthGuard]
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
