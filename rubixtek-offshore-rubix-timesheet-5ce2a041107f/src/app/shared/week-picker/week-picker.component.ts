import { formatDate } from "@angular/common";
import {
  Component,
  ViewChild,
  EventEmitter,
  forwardRef,
  AfterViewInit,
  Input,
  Output
} from "@angular/core";
import {
  FormControl,
  NgControl,
  ControlValueAccessor,
  AbstractControl,
  ValidationErrors,
  NG_VALUE_ACCESSOR,
  NG_VALIDATORS
} from "@angular/forms";
import {
  NgbDate,
  NgbCalendar,
  NgbDatepicker
} from "@ng-bootstrap/ng-bootstrap";


@Component({
  selector: 'app-week-picker',
  templateUrl: './week-picker.component.html',
  styleUrls: ['./week-picker.component.scss'],
  providers: [
    {
      provide: NG_VALUE_ACCESSOR,
      useExisting: forwardRef(() => WeekPickerComponent),
      multi: true
    }
  ]
})
export class WeekPickerComponent implements ControlValueAccessor,  AfterViewInit {

  fromDate: NgbDate;
  toDate: NgbDate;
  @Output() sendDate=new EventEmitter();
  dates:any={startDate:Date,endDate:Date};
  startDate:Date;
  endDate:Date;
  @ViewChild(NgbDatepicker, { static: false }) datePicker;

  set week(value) {
    this.onChange({ year: this.fromDate.year, week: value });
  }

  disabled: boolean = false;
  onChange: (_: any) => void;
  onTouched: any;
  constructor(private ngbCalendar: NgbCalendar) {}
  onDateSelection(date: NgbDate) {
    let fromDate = new Date(date.year + "-" + date.month + "-" + date.day);
    let time = fromDate.getDay() ? fromDate.getDay() - 1 : 6;
    fromDate = new Date(fromDate.getTime() - time * 24 * 60 * 60 * 1000);
    this.fromDate = new NgbDate(
      fromDate.getFullYear(),
      fromDate.getMonth() + 1,
      fromDate.getDate()
    );
    this.startDate= new Date( fromDate.getFullYear(),fromDate.getMonth(),
      fromDate.getDate());
      
      
     
    const toDate = new Date(fromDate.getTime() + 6 * 24 * 60 * 60 * 1000);
    this.toDate = new NgbDate(
      toDate.getFullYear(),
      toDate.getMonth() + 1,
      toDate.getDate()
    );
    this.endDate= new Date( toDate.getFullYear(),toDate.getMonth(),
      toDate.getDate());
      this.dates.startDate=this.startDate;
      this.dates.endDate=this.endDate;
      this.sendDate.emit(this.dates);
    if (this.onTouched) this.onTouched();
    if (this.onChange) this.week = this.calculateWeek(fromDate);
  }
  isInside(date: NgbDate) {
    return date.after(this.fromDate) && date.before(this.toDate);
  }

  isRange(date: NgbDate) {
    return (
      date.equals(this.fromDate) ||
      date.equals(this.toDate) ||
      this.isInside(date)
    );
  }

  calculateWeek(date: any) {
    const time = date.getTime() + 4 * 24 * 60 * 60 * 1000;
    const firstDay = new Date(date.getFullYear() + "-1-1");
    return (
      Math.floor(Math.round((time - firstDay.getTime()) / 86400000) / 7) + 1
    );
  }
  calculateDate(week: number, year: number) {
    const firstDay = new Date(year + "-1-4");
    const date = new Date(
      firstDay.getTime() + (week - 1) * 7 * 24 * 60 * 60 * 1000
    );
    const selectDate = new NgbDate(
      date.getFullYear(),
      date.getMonth() + 1,
      date.getDate()
    );
    this.onDateSelection(selectDate);
  }
  ngAfterViewInit() {
    if (this.fromDate) {
      setTimeout(() => {
        this.datePicker.navigateTo(this.fromDate);
      });
    }
  }

  registerOnChange(fn: (_: any) => void): void {
    this.onChange = fn;
  }

  registerOnTouched(fn: any): void {
    this.onTouched = fn;
  }

  setDisabledState(isDisabled: boolean): void {
    this.disabled = isDisabled;
  }
  writeValue(value: any): void {
    if (value) {
      this.calculateDate(value.week, value.year);
    }
  }
  
}
