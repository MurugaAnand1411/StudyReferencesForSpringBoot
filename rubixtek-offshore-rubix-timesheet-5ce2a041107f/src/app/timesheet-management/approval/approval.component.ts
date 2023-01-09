import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import moment from 'moment';
import { NgxSpinnerService } from 'ngx-spinner';
import { ToastrService } from 'ngx-toastr';
import { TeamLeadService } from 'src/app/service/admin/team-lead.service';
import { EmployeeService } from 'src/app/service/employee/employee.service';
import { Timesheet } from 'src/app/shared/model/timesheet';
import { TimesheetDetail } from 'src/app/shared/model/timesheetDetail';

@Component({
  selector: 'app-approval',
  templateUrl: './approval.component.html',
  styleUrls: ['./approval.component.scss']
})
export class ApprovalComponent implements OnInit {
  timesheetId:any;
  timesheet:any={};
  task:any={};
taskId:any;
day:any=[];
  constructor(private adminService: TeamLeadService,private spinner: NgxSpinnerService,private toastr: ToastrService, private employeeService:EmployeeService,private route: ActivatedRoute,
    private router: Router,) { }

  ngOnInit(): void {
    this.timesheetId = this.route.snapshot.params['id'];
    this.taskId = this.route.snapshot.params['taskId'];
    this.getTimesheet();
    this.getTask();
  }
  getTimesheet(){
    this.adminService.getTimesheetById(this.timesheetId).subscribe(data=>{
      this.timesheet=data;
      console.log(this.timesheet);
    })
  }
  getTask(){
    this.employeeService.getTaskById(this.taskId).subscribe(data=>{
      this.task=data;
      for (let i = 0; i < this.task.daterange.length; i++) {
        var momentVariable = moment(this.task.daterange[i].date, 'DD-MM-YYYY');
        this.day[i] = momentVariable.format('ddd');
        console.log(this.day[i]);
        this.task.daterange[i].date = momentVariable.format('MM/DD');
        console.log(this.task.daterange[i]);
     
      }
      console.log(this.task);
    })
  }
  onApprove(){
    this.spinner.show();
    this.adminService.approveTimesheetById(this.timesheetId).subscribe(data=>{
      console.log(data);
    },err=>{
      this.spinner.hide();
      this.toastr.info('Timesheet has been Approved')
      this.router.navigate(['/timesheet-manage/list'])
      console.log(err);
    })
  }
  onReject(){
    this.spinner.show();
    this.adminService.rejectTimesheetById(this.timesheetId).subscribe(data=>{
      console.log(data);
    },err=>{
      this.spinner.hide();
      this.toastr.info('Timesheet has been Approved')
      this.router.navigate(['/timesheet-manage/list'])
      console.log(err);
    })
  }
}
