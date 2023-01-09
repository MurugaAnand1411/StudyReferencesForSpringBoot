import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import moment from 'moment';
import { EmployeeService } from 'src/app/service/employee/employee.service';

@Component({
  selector: 'app-view-taskdetail',
  templateUrl: './view-taskdetail.component.html',
  styleUrls: ['./view-taskdetail.component.scss']
})
export class ViewTaskdetailComponent implements OnInit {
  timesheetId: any;
  taskId: any;
  task: any={};
  day:any=[];
  constructor( private employeeService: EmployeeService, private route: ActivatedRoute,
    private router: Router,) { }

  ngOnInit(): void {
    this.timesheetId = this.route.snapshot.params['timesheetId'];
    this.taskId = this.route.snapshot.params['taskId'];
    this.getTaskDetail();
  }
  getTaskDetail() {
   
    this.employeeService.getTaskById(this.taskId).subscribe(data => {
      
      this.task=data;
      for (let i = 0; i < this.task.daterange.length; i++) {
        var momentVariable = moment(this.task.daterange[i].date, 'DD-MM-YYYY');
        this.day[i] = momentVariable.format('ddd');
        console.log(this.day[i]);
        this.task.daterange[i].date = momentVariable.format('MM/DD');
        console.log(this.task.daterange[i]);
     
      }
      console.log(this.task);
    });
   
  }
}
