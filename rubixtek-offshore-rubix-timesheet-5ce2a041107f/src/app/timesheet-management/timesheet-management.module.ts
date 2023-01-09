import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { TimesheetManagementRoutingModule } from './timesheet-management-routing.module';
import { SharedModule } from '../shared/shared.module';
import { ApprovalComponent } from './approval/approval.component';
import { TimesheetRecordComponent } from './timesheet-record/timesheet-record.component';
import { TimesheetApprovalListComponent } from './timesheet-approval-list/timesheet-approval-list.component';


@NgModule({
  declarations: [ApprovalComponent,TimesheetRecordComponent,TimesheetApprovalListComponent],
  imports: [
    CommonModule,
    SharedModule,
    TimesheetManagementRoutingModule
  ]
})
export class TimesheetManagementModule { }
