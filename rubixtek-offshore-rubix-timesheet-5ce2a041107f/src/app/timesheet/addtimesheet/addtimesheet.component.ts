import { formatDate } from '@angular/common';
import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { CustomValidators, ValidateNumber, ValidatePassword } from 'src/app/shared/util';
import { DateAdapter, MAT_DATE_FORMATS } from '@angular/material/core';
import { AppDateAdapter, APP_DATE_FORMATS } from 'src/app/shared/util';
import { Timesheet } from 'src/app/shared/model/timesheet';
import { MatDateRangeSelectionStrategy, DateRange, MAT_DATE_RANGE_SELECTION_STRATEGY, MatCalendarCellCssClasses, MatCalendarCellClassFunction } from '@angular/material/datepicker';
import { Injectable } from '@angular/core';
import { EmployeeService } from 'src/app/service/employee/employee.service';
import { Router } from '@angular/router';
import { GridColumnStyleBuilder } from '@angular/flex-layout/grid/typings/column/column';
import { mapToMapExpression } from '@angular/compiler/src/render3/util';
import { FormControl } from '@angular/forms';
import { DatePipe } from '@angular/common';
import { NgxSpinnerService } from 'ngx-spinner';
import { Supervisor } from 'src/app/shared/model/employee';
@Injectable()
export class FiveDayRangeSelectionStrategy<D> implements MatDateRangeSelectionStrategy<D> {
  constructor(private _dateAdapter: DateAdapter<D>) { }

  selectionFinished(date: D | null): DateRange<D> {
    return this._createFiveDayRange(date);
  }

  createPreview(activeDate: D | null): DateRange<D> {
    return this._createFiveDayRange(activeDate);
  }

  private _createFiveDayRange(date: D | null): DateRange<D> {
    if (date) {
      const start = this._dateAdapter.addCalendarDays(date, -3);
      const end = this._dateAdapter.addCalendarDays(date, 3);
      return new DateRange<D>(start, end);
    }

    return new DateRange<D>(null, null);
  }
}
@Component({
  selector: 'app-addtimesheet',
  templateUrl: './addtimesheet.component.html',
  styleUrls: ['./addtimesheet.component.scss'],
  providers: [
    {
      provide: MAT_DATE_RANGE_SELECTION_STRATEGY,
      useClass: FiveDayRangeSelectionStrategy
    },
    { provide: DateAdapter, useClass: AppDateAdapter },
    { provide: MAT_DATE_FORMATS, useValue: APP_DATE_FORMATS }
  ],
  encapsulation: ViewEncapsulation.None,
})
export class AddtimesheetComponent implements OnInit {
  timesheetForm: FormGroup;
  timesheet = new Timesheet();
  timesheetId: any;
  finaldate = '';
  initialdate:any='';
  today = new Date();
  week: number = 1;
  currentDate=new Date();
  formControl: FormControl;
  supervisor:Supervisor[];
  selectSupervisor:String;
  constructor(private router: Router, public fb: FormBuilder, private spinner: NgxSpinnerService,private employeeService: EmployeeService) {
    this.today.setDate(this.today.getDate());
    this.week = this.calculateWeek(this.currentDate);
    this.formControl = new FormControl({ year: this.currentDate.getFullYear(), week: this.week }, Validators.required)
  }
  ngOnInit(): void {
    this.timesheetForm = this.fb.group({

      teamname: ['', [Validators.required]],
      startDate: ['', [Validators.required]],
      endDate: ['', [Validators.required]],
      timesheetApprover: ['', [Validators.required]],
    });
    this.getAdmin();
  }
  public checkError = (controlName: string, errorName: string) => {
    return this.timesheetForm.controls[controlName].hasError(errorName);
  }
  calculateWeek(date: any) {
    const time = date.getTime() + 4 * 24 * 60 * 60 * 1000;
    const firstDay = new Date(date.getFullYear() + "-1-1");
    return (
      Math.floor(Math.round((time - firstDay.getTime()) / 86400000) / 7)
    );
  }
  onSubmit() {
    console.log(this.timesheetForm.value);
    this.spinner.show();
    this.employeeService.addNewTimesheet(this.timesheetForm.value).subscribe(( data)=>{this.timesheetId=data;this.spinner.hide();
      this.router.navigate(['/timesheet/task',this.timesheetId,'add'])
    },(err)=>{console.log(err)}); 
   
  }


  getAdmin() {
    this.employeeService.getAllAdmins().subscribe(data => {this.supervisor=data; this.selectSupervisor=this.supervisor[0].employeeId; console.log(this.supervisor) });
  }

  
  addStart(date) {
    console.log(date);
    this.initialdate=formatDate(date.startDate,'dd/MM/yyyy','en-GB');
    this.finaldate=formatDate(date.endDate,'dd/MM/yyyy','en-GB');
    this.week = this.calculateWeek(date.startDate)
    console.log(this.week);
  }
}
