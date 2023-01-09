import { formatDate } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { EmployeeService } from 'src/app/service/employee/employee.service';
import { Timesheet } from 'src/app/shared/model/timesheet';
import * as _moment from 'moment';
import { default as _rollupMoment } from 'moment';
import { AbstractControl, FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { DateRange } from '../../shared/model/dateRange';
import { FormArray } from '@angular/forms';
import { TimesheetDetail } from 'src/app/shared/model/timesheetDetail';
import { errorMessages } from 'src/app/shared/constants';
import { ValidateHourNumeric } from 'src/app/shared/util';
import { BehaviorSubject } from 'rxjs';
import { NgxSpinnerService } from 'ngx-spinner';
import { ToastrService } from 'ngx-toastr';
import { ProjectService } from 'src/app/service/project/project.service';
const moment = _rollupMoment || _moment;
@Component({
  selector: 'app-add-taskdetail',
  templateUrl: './add-taskdetail.component.html',
  styleUrls: ['./add-taskdetail.component.scss']
})
export class AddTaskdetailComponent implements OnInit {

  tasks = new FormArray([]);
  errors = errorMessages;
  timesheetId: any;
  timesheet = new Timesheet();
  timesheetDetail = new TimesheetDetail();
  dateRange: DateRange[] = [];
  holidayTimeoff: any = [];
  applyTimeoff: any = [];

  day: any = [];
  timesheetDetailForm: FormGroup;
  sampleForm: FormGroup;
  datRange: any = [];
  datsRange: any = [];
  taskId: any;
  saved: Boolean = false;
  editMode: Boolean = false;
  total_daily_hour: number = 0;
  total_holiday_hour: number = 0;
  total_timeoff_hour: number = 0;
  total_hours: any = 0;
  project:any;
  constructor(public fb: FormBuilder,private projectService:ProjectService, private employeeService: EmployeeService, private route: ActivatedRoute,
    private router: Router, private spinner: NgxSpinnerService, private toastr: ToastrService) { }
  getForms() {
    this.timesheetDetailForm = this.fb.group({
      projectname: ['', [Validators.required]],
      task: ['', [Validators.required]],
      daterange: this.fb.array([]),
      // holidaytimeoff: this.fb.array([]),
      // applytimeoff: this.fb.array([])
    });
  }
  getProjectName(){
    this.projectService.getAll().subscribe(data=>{
this.project=data;
    })
  }
  ngOnInit(): void {
    this.timesheetId = this.route.snapshot.params['timesheetId'];
    this.taskId = this.route.snapshot.params['taskId'];
    this.getProjectName();
    console.log(this.taskId);
    this.getForms();
    if (this.taskId == 'add') {
      this.editMode = false;
      console.log("Initial Adding");
      this.addtimesheetDetailForm();
    } else {
      console.log("Initial editing");
      this.editMode = true;
      this.getTaskDetail();
      this.getTimesheetById();
    }

  }

  getTaskDetail() {
    this.employeeService.getTaskById(this.taskId).subscribe(data => {
      this.timesheetDetailForm.patchValue(data);
      this.timesheetDetail = data;
      this.getDateDetails();
      // this.getApplytimeoffDetails();
      // this.getHolidaytimeoffDetails();
      console.log(this.timesheetDetailForm.value)
    });
    this.saved = true;
  }
  addtimesheetDetailForm() {
    this.getTimesheetById();
  }
  getTimesheetById() {
    this.employeeService.getTimesheetById(this.timesheetId).subscribe((data) => {
      this.timesheet = data;
      console.log(this.timesheet);
      this.datRange = [];
      this.day = [];
      for (let i = 0; i < this.timesheet.dateRange.length; i++) {
        var momentVariable = moment(this.timesheet.dateRange[i], 'DD-MM-YYYY');
        var str = momentVariable.format('ddd');
        console.log(str);
        var stringvalue = momentVariable.format('MM/DD');
        console.log(stringvalue);

        this.datRange.push(stringvalue);
        this.day.push(str);
        this.dateRange.push({
          dateRangeId: '',
          date: this.timesheet.dateRange[i],
          hours: '0',
        });
        // this.holidayTimeoff.push({
        //   holidaytimeoffId: '',
        //   date: this.timesheet.dateRange[i],
        //   hours: '0',
        // });
        // this.applyTimeoff.push({
        //   applytimeoffId: '',
        //   date: this.timesheet.dateRange[i],
        //   hours: '0',
        // });
      }
      if (this.taskId == 'add') {
        this.addDateDetails();
        // this.addApplytimeoffDetails();
        // this.addHolidaytimeoffDetails();
      }
    })
  }
  submitForApproval() {
    console.log(this.taskId);
    this.spinner.show();
    this.employeeService.submitForApproval(this.timesheetId, this.taskId, this.total_hours).subscribe(data => {
      console.log(data);
      this.router.navigate(['/timesheet']);
    }, err => {
      console.log(err);
      this.spinner.hide();
      this.router.navigate(['/timesheet']);
      this.toastr.info('Timesheet Submitted for Approval');
    })

  }

  onSubmit() {
    this.spinner.show();
    if (this.timesheetDetailForm.valid) {
      console.log(this.timesheetDetailForm.value);
      if (this.editMode) {
        console.log("Editting");
        console.log(this.timesheetDetailForm.value);
        this.employeeService.editTaskDetail(this.timesheetDetailForm.value, this.timesheetId, this.taskId).subscribe(
          data => { console.log(data); },
          err => { console.log(err); this.spinner.hide(); this.toastr.success('Updated Successfully'); }
        )
      } else {
        console.log("Adding");
        this.employeeService.addTaskdetails(this.timesheetDetailForm.value, this.timesheetId).subscribe(data => {
          console.log(data);
          this.spinner.hide();
          this.toastr.success('Saved Successfully');
          this.saved = true;
          this.taskId = data;
          this.getForms();
          this.editMode = true;
          this.getTaskDetail();
          this.getTimesheetById();
          this.router.navigate(['/timesheet/task', this.timesheetId, this.taskId]);

        },
          err => {
            this.spinner.hide();
          });
      }
    } else {
      console.log("Not Validated properly");
    }
  }

  addDategroup() {

    return this.fb.group({
      dateRangeId: [''],
      date: ['', Validators.required],
      hours: ['', [Validators.required, ValidateHourNumeric]]


    });

  }
  addDatetype() {
    this.dateArray.push(this.addDategroup());
  }
  get dateArray() {
    return <FormArray>this.timesheetDetailForm.get('daterange');
  }
  //holidayTimeoff
  addholidaygroup() {

    return this.fb.group({
      holidaytimeoffId: [''],
      date: ['', Validators.required],
      hours: ['', [Validators.required, ValidateHourNumeric]]


    });

  }
  addHolidaytype() {
    this.dateArray.push(this.addDategroup());
  }
  get holidayArray() {
    return <FormArray>this.timesheetDetailForm.get('holidaytimeoff');
  }
  // applytimeoff
  addTimeoffgroup() {

    return this.fb.group({
      applytimeoffId: [''],
      date: ['', Validators.required],
      hours: ['', [Validators.required, ValidateHourNumeric]]


    });

  }
  addTimeofftype() {
    this.dateArray.push(this.addDategroup());
  }
  get timeOffArray() {
    return <FormArray>this.timesheetDetailForm.get('applytimeoff');
  }
  errorMessage(controlName: string, Name: string): string {
    const form: FormControl = (this.timesheetDetailForm.get(controlName) as FormControl);
    return form.hasError('required') ?
      Name + this.errors.required : '';
  }
  arrayErrorMessage(index: number, arrayName: FormArray, controlName: string, Name: string): string {
    const form: FormArray = (arrayName.controls[index].get(controlName) as FormArray);
    return form.hasError('required') ?
      Name + this.errors.required :
      form.hasError('invalidNumber') ?
        this.errors.valid + Name : '';
  }
  addDateDetails() {

    const control = <FormArray>this.timesheetDetailForm.controls.daterange;
    this.dateRange.forEach(x => {
      control.push(this.fb.group({
        dateRangeId: x.dateRangeId,
        date: [x.date, Validators.required],
        hours: [x.hours, [Validators.required, ValidateHourNumeric]]

      }))
    });

    return control;
  }
  addHolidaytimeoffDetails() {

    const control = <FormArray>this.timesheetDetailForm.controls.holidaytimeoff;
    this.holidayTimeoff.forEach(x => {
      control.push(this.fb.group({
        holidaytimeoffId: x.dateRangeId,
        date: [x.date, Validators.required],
        hours: [x.hours, [Validators.required, ValidateHourNumeric]]

      }))
    });
    return control;
  }
  addApplytimeoffDetails() {

    const control = <FormArray>this.timesheetDetailForm.controls.applytimeoff;
    this.applyTimeoff.forEach(x => {
      control.push(this.fb.group({
        applytimeoffId: x.dateRangeId,
        date: [x.date, Validators.required],
        hours: [x.hours, [Validators.required, ValidateHourNumeric]]

      }))
    });
    return control;
  }
  getDateDetails() {

    const control = <FormArray>this.timesheetDetailForm.controls.daterange;
    this.timesheetDetail.daterange.forEach(x => {
      control.push(this.fb.group({
        dateRangeId: x.dateRangeId,
        date: [x.date, Validators.required],
        hours: [x.hours, [Validators.required, ValidateHourNumeric]]

      }))

    });
    this.getBillingHours();
    return control;
  }


  getHolidaytimeoffDetails() {

    const control = <FormArray>this.timesheetDetailForm.controls.holidaytimeoff;
    this.timesheetDetail.holidaytimeoff.forEach(x => {
      control.push(this.fb.group({
        holidaytimeoffId: x.holidaytimeoffId,
        date: [x.date, Validators.required],
        hours: [x.hours, [Validators.required, ValidateHourNumeric]]

      }))
    });
    this.getHolidayHours();
    return control;
  }
  getApplytimeoffDetails() {

    const control = <FormArray>this.timesheetDetailForm.controls.applytimeoff;
    this.timesheetDetail.applytimeoff.forEach(x => {
      control.push(this.fb.group({
        applytimeoffId: x.applytimeoffId,
        date: [x.date, Validators.required],
        hours: [x.hours, [Validators.required, ValidateHourNumeric]]

      }))
    });
    this.getTimeoffHours();
    return control;
  }
  getBillingHours() {
    this.total_daily_hour = 0;
    console.log(this.timesheetDetailForm.value.daterange.length);
    for (let i = 0; i < this.timesheetDetailForm.value.daterange.length; i++) {

      this.total_daily_hour += +this.timesheetDetailForm.value.daterange[i].hours;
    }
    this.total_hours = this.total_daily_hour + this.total_holiday_hour + this.total_timeoff_hour;

  }
  getHolidayHours() {
    this.total_holiday_hour = 0;
    console.log(this.timesheetDetailForm.value.holidaytimeoff.length);
    for (let i = 0; i < this.timesheetDetailForm.value.holidaytimeoff.length; i++) {

      this.total_holiday_hour += +this.timesheetDetailForm.value.holidaytimeoff[i].hours;
    }
    this.total_hours = this.total_daily_hour + this.total_holiday_hour + this.total_timeoff_hour;
  }
  getTimeoffHours() {
    this.total_timeoff_hour = 0;
    console.log(this.timesheetDetailForm.value.applytimeoff.length);
    for (let i = 0; i < this.timesheetDetailForm.value.applytimeoff.length; i++) {

      this.total_timeoff_hour += +this.timesheetDetailForm.value.applytimeoff[i].hours;
    }
    this.total_hours = this.total_daily_hour + this.total_holiday_hour + this.total_timeoff_hour;
  }

}
