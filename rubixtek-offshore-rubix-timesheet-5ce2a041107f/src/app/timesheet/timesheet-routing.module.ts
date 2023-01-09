import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AddtimesheetComponent } from './addtimesheet/addtimesheet.component';
import { ViewTimesheetComponent } from './view-timesheet/view-timesheet.component';
import { ViewTaskdetailComponent } from './view-taskdetail/view-taskdetail.component';
import { AddTaskdetailComponent } from './add-taskdetail/add-taskdetail.component';
import { LayoutComponent } from '../shared/navigation-contents/layout/layout.component';
const routes: Routes = [
  {
    path: '',
    component: LayoutComponent,
    children: [
      { path: '', component: ViewTimesheetComponent },
    ]
  },
  {
    path: '',
    component: LayoutComponent,
    children: [
      { path: 'addtimesheet', component: AddtimesheetComponent },
    ]
  },
  {
    path: '',
    component: LayoutComponent,
    children: [
      { path: 'task/:timesheetId/:taskId', component: AddTaskdetailComponent },
    ]
  },
  {
    path: '',
    component: LayoutComponent,
    children: [
      { path: 'viewtask/:timesheetId/:taskId', component: ViewTaskdetailComponent },
    ]
  },
  

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class TimesheetRoutingModule { }
