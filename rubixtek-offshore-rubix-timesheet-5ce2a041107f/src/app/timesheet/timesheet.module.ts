import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import{SharedModule} from '../shared/shared.module';
import { TimesheetRoutingModule } from './timesheet-routing.module';
import { AddtimesheetComponent } from './addtimesheet/addtimesheet.component';
import { ViewTimesheetComponent } from './view-timesheet/view-timesheet.component';
import { ViewTaskdetailComponent } from './view-taskdetail/view-taskdetail.component';
import { AddTaskdetailComponent } from './add-taskdetail/add-taskdetail.component';
import { ErrorStateMatcher } from '@angular/material/core';



@NgModule({
  declarations: [AddtimesheetComponent, ViewTimesheetComponent, ViewTaskdetailComponent, AddTaskdetailComponent],
  imports: [
    CommonModule,
    SharedModule,
    TimesheetRoutingModule
  ],
  providers: [
 
  ],

})
export class TimesheetModule { }
