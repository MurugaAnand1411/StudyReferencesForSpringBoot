import { DatePipe } from '@angular/common';
import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { FormBuilder, FormControl, Validators } from '@angular/forms';
import { MatDatepickerInputEvent } from '@angular/material/datepicker';
import { Sort } from '@angular/material/sort';
import { TeamLeadService } from 'src/app/service/admin/team-lead.service';
import { errorMessages } from 'src/app/shared/constants';
import { sortDatas, validateDate } from 'src/app/shared/util';

@Component({
  selector: 'app-timesheet-record',
  templateUrl: './timesheet-record.component.html',
  styleUrls: ['./timesheet-record.component.scss'],
  providers: [DatePipe]
})
export class TimesheetRecordComponent implements OnInit {
  ff:any;
  ll:any;
  excelForm: any;
  timesheet:any;
  tableColumns: { name: string; dataKey: string; isSortable: boolean; }[];
  constructor(public fb: FormBuilder, private datePipe: DatePipe, private adminService: TeamLeadService) { }

  ngOnInit(): void {
    
    let dat = new Date();
    this.ff = this.datePipe.transform(new Date(dat.getFullYear(), dat.getMonth(), 1), "yyyy-MM-dd");
    this.ll = this.datePipe.transform(new Date(dat.getFullYear(), dat.getMonth() + 1, 0), "yyyy-MM-dd")
    this.excelForm = this.fb.group({
      start_date: ['', Validators.required],
      end_date: ['', Validators.required]
    }, { validators: validateDate });
    this.getAllApprovedTimesheet();
    this.initColums();
  }
  getAllApprovedTimesheet() {
    this.adminService.getAllApprovedTimesheet(this.ff,this.ll).subscribe(data => {
      console.log(data);this.timesheet=data;
    });
  }
 
  autoGrow1() {
    this.ff = this.datePipe.transform(new Date(this.ff.getFullYear(), this.ff.getMonth(),this.ff.getDate()), "yyyy-MM-dd");
    this.getAllApprovedTimesheet();
  }
  autoGrow2() {
    this.ll = this.datePipe.transform(new Date(this.ll.getFullYear(), this.ll.getMonth(),this.ll.getDate()), "yyyy-MM-dd");
    this.getAllApprovedTimesheet();
    
  }
  initColums():void{
    this.tableColumns=[
      {
        name: 'Employee Name',
        dataKey: 'employeeName',
        isSortable: true
      },
      // {
      //   name: 'Team Name',
      //   dataKey: 'teamname',
      //   isSortable: true
      // },
      {
        name: 'Project Name',
        dataKey: 'projectName',
        isSortable: true
      },
      {
        name: ' Start Date',
        dataKey: 'startDate',
        isSortable: true
      },
      {
        name: 'End Date',
        dataKey: 'endDate',
        isSortable: true
      },
      {
        name: 'Billable Hours',
        dataKey: 'billableHours',
        isSortable: true
      },
      {
        name: 'Submitted Date',
        dataKey: 'submittedDate',
        isSortable: true
      },
      {
        name: 'Approver',
        dataKey: 'timesheetApprover',
        isSortable: true
      },
      {
        name: 'Status',
        dataKey: 'status',
        isSortable: true
      }
      
    ];
    }
    sort(sortParameters: Sort) {
      sortDatas(this.timesheet,sortParameters);
    }
    errors = errorMessages;
    errorMessage(controlName: string, Name: string): string {
      const form: FormControl = (this.excelForm.get(controlName) as FormControl);
      return form.hasError('required') ?
        Name + this.errors.required  :
          form.hasError('invalid') ?
            "Start Date should be lesser than End Date" :'';
    }
  }
