import { AfterViewInit } from '@angular/core';
import { Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { Sort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { Router } from '@angular/router';
import { EmployeeService } from 'src/app/service/employee/employee.service';
import { sortDatas } from 'src/app/shared/util';

@Component({
  selector: 'app-view-timesheet',
  templateUrl: './view-timesheet.component.html',
  styleUrls: ['./view-timesheet.component.scss']
})
export class ViewTimesheetComponent implements OnInit {
  datea:any
 timesheet:any=[];
  tableColumns: { name: string; dataKey: string; isSortable: boolean; }[];

  constructor( private router: Router,private employeeService:EmployeeService) { }

  ngOnInit(): void {
    this.viewallTimesheet();
    this.initColums();
  }

viewallTimesheet(){
  this.employeeService.getAllTimesheetByEmpId().subscribe(data=>{
    this.datea=data;
  });
}
deleteTimesheet(data){
  this.employeeService.deleteTimesheetById(data).subscribe((data)=>{this.viewallTimesheet()},(err)=>{this.viewallTimesheet()});
}
editTimesheet(data){
  console.log(data.timesheetDetailId);
  this.router.navigate(['/timesheet/task',data.timesheetId,data.timesheetDetailId])
}
readTimesheet(data){
  console.log(data.timesheetDetailId);
  this.router.navigate(['/timesheet/viewtask',data.timesheetId,data.timesheetDetailId])
}
initColums():void{
this.tableColumns=[
  {
    name: 'Id',
    dataKey: 'timesheetId',
    isSortable: true
  },
  {
    name: 'Team Name',
    dataKey: 'teamname',
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
  sortDatas(this.datea,sortParameters);
}

}
