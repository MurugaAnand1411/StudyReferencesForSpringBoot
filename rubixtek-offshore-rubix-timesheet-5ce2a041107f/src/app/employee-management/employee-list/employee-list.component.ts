import { Component, OnInit } from '@angular/core';
import { Sort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { TeamLeadService } from 'src/app/service/admin/team-lead.service';
import { sortDatas } from 'src/app/shared/util';

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.scss']
})
export class EmployeeListComponent implements OnInit { 
  employee:any=[];
  tableColumns: { name: string; dataKey: string; isSortable: boolean; }[];
  constructor( private toastr: ToastrService,private adminService:TeamLeadService,private router:Router) { }

  ngOnInit(): void {
    this.getAllEmployeeDetails();
    this.initColums();
  }
getAllEmployeeDetails(){
this.adminService.getAllEmployees().subscribe(data=>{
  this.employee=data;
  console.log(data);
})
}
readEmployee(empId:any){
this.router.navigate(['/admin/employees/data',empId]);
}
editEmployee(empId:any){
  this.router.navigate(['/admin/employees/data',empId])
}
paySlip(empId:any){
  this.router.navigate(['/admin/payslip'])
}
deleteEmployee(empId:any){
console.log("Delete emp" + empId);
this.adminService.deleteEmployee(empId).subscribe(data=>{
  console.log(data)
},err=>{
  this.toastr.info('Employee Record Deleted');
  this.getAllEmployeeDetails();
})
}
initColums():void{
  this.tableColumns=[
    {
      name: 'Id',
      dataKey: 'employeeId',
      isSortable: true
    },
    {
      name: 'First Name',
      dataKey: 'firstname',
      isSortable: true
    },
    {
      name: ' Email Id',
      dataKey: 'emailId',
      isSortable: true
    },
    {
      name: 'Mobile No',
      dataKey: 'mobileno',
      isSortable: true
    }
    
  ];
  }
  sort(sortParameters: Sort) {
    sortDatas(this.employee,sortParameters);
  }
}
