import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LayoutComponent } from '../shared/navigation-contents/layout/layout.component';
import { ApprovalComponent } from './approval/approval.component';
import { TimesheetApprovalListComponent } from './timesheet-approval-list/timesheet-approval-list.component';
import { TimesheetRecordComponent } from './timesheet-record/timesheet-record.component';

const routes: Routes = [
  {
    path: '',
    component: LayoutComponent,
    children: [
      { path: 'view/:id/:taskId', component: ApprovalComponent},
    ]
  },
  {
    path: '',
    component: LayoutComponent,
    children: [
      { path: 'list', component: TimesheetApprovalListComponent},
    ]
  },
  {
    path: '',
    component: LayoutComponent,
    children: [
      { path: 'record', component: TimesheetRecordComponent},
    ]
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class TimesheetManagementRoutingModule { }
