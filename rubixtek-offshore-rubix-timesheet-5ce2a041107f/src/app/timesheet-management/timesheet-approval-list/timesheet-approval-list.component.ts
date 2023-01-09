import { Component, OnInit } from '@angular/core';
import { Sort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { Router } from '@angular/router';
import { NgxSpinnerService } from 'ngx-spinner';
import { ToastrService } from 'ngx-toastr';
import { TeamLeadService } from 'src/app/service/admin/team-lead.service';
import { sortDatas } from 'src/app/shared/util';

@Component({
  selector: 'app-timesheet-approval-list',
  templateUrl: './timesheet-approval-list.component.html',
  styleUrls: ['./timesheet-approval-list.component.scss']
})
export class TimesheetApprovalListComponent implements OnInit {
  timesheet:any=[];
  tableColumns: { name: string; dataKey: string; isSortable: boolean; }[];
  constructor(private adminService:TeamLeadService,private router:Router,private spinner: NgxSpinnerService,private toastr: ToastrService) { }

  ngOnInit(): void {
this.getTimesheet();
this.initColums();
  }
getTimesheet(){
  this.adminService.getAllTimesheetForApproval().subscribe(data=>{
    this.timesheet=data;
    console.log(data);
  });
}
readTimesheet(data){
  this.router.navigate(['/timesheet-manage/view',data.timesheetId,data.timesheetDetailId]);
 
}
onApprove(data){
  this.spinner.show();
  console.log(data);
  this.adminService.approveTimesheetById(data).subscribe(data=>{
    console.log(data);
  },err=>{this.spinner.hide(); this.toastr.info('Timesheet has been Approved');this.getTimesheet();})
}
onReject(data){
  this.spinner.show();
  this.adminService.rejectTimesheetById(data).subscribe(data=>{
    console.log(data);
  },err=>{this.spinner.hide(); this.toastr.info('Timesheet has been rejected');this.getTimesheet()})
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
}
