import { AbstractControl, FormControl,ValidatorFn } from '@angular/forms';
import { constants } from './constants';
import { NativeDateAdapter } from '@angular/material/core';
import { MatDateFormats } from '@angular/material/core';
import {MomentDateAdapter, MAT_MOMENT_DATE_ADAPTER_OPTIONS} from '@angular/material-moment-adapter';
import {DateAdapter, MAT_DATE_FORMATS, MAT_DATE_LOCALE} from '@angular/material/core';
import * as moment from 'moment';
import { Sort } from '@angular/material/sort';

export const MY_FORMATS = {
  parse: {
    dateInput: 'LL', 
  },
  display: {
    dateInput: 'MMMM YYYY', // this is the format showing on the input element
    monthYearLabel: 'MMMM YYYY', // this is showing on the calendar 
  },
};

export class AppDateAdapter extends NativeDateAdapter {
  format(date: Date, displayFormat: Object): string {
    if (displayFormat === 'input') {
      let day: string = date.getDate().toString();
      day = +day < 10 ? '0' + day : day;
      let month: string = (date.getMonth() + 1).toString();
      month = +month < 10 ? '0' + month : month;
      let year = date.getFullYear();
      return `${day}-${month}-${year}`;
    }
    return date.toDateString();
  }
}
export const APP_DATE_FORMATS: MatDateFormats = {
  parse: {
    dateInput: { month: 'short', year: 'numeric', day:'numeric' },
  },
  display: {
    dateInput: 'input',
    monthYearLabel: { year: 'numeric', month: 'numeric' },
    dateA11yLabel: { year: 'numeric', month: 'long', day: 'numeric'
    },
    monthYearA11yLabel: { year: 'numeric', month: 'long' },
  }
};

export class CustomValidators {
  static passwordMatchValidator(control: AbstractControl) {
    const password: string = control.get('password').value;
    const confirmPassword: string = control.get('rcpassword').value;
    if (password !== confirmPassword) {
      control.get('rcpassword').setErrors({ NoPassswordMatch: true });
    }
  }
  static emailExistValidator(emailId: Boolean): (control: AbstractControl) => { [key: string]: boolean } | null {
    return (control: AbstractControl): { [key: string]: boolean } | null => {

      if (!control.value || 0 === control.value.length) {
        return null;
      }
      else if (emailId) {
        return { 'EmailExist': true };
      }
      else
        return null;
    };
  }
}
export function noWhitespaceValidator(): ValidatorFn {
  return (control: FormControl): { [key: string]: any } => {
    const isWhitespace = (control.value || '').trim().length === 0;
    const isValid = !isWhitespace;
    return isValid ? null : { 'whitespace': true };
  }
}

export function ValidateAlphaNumeric(control: AbstractControl) {
  if (control && (control.value !== null || control.value !== undefined)) {
    const regex = new RegExp(constants.AlphaNumericRegEx);
    if (!regex.test(control.value)) {
      return {
        'notValid': true
      };
    }
  }
  return null;

}

export function ValidateHourNumeric(control: AbstractControl) {
  if (control && (control.value !== null || control.value !== undefined)) {
    const regex = new RegExp(/^[0-8]{1}$/);
    if (!regex.test(control.value)) {
      return {
        'invalidNumber': true
      }; 
    }
  }
  return null;
}
export function ValidateNumeric(control: AbstractControl) {
  if (control && (control.value !== null || control.value !== undefined)) {
    const regex = new RegExp(/^[0-9]{6}$/);
    if (!regex.test(control.value)) {
      return {
        'invalidNumber': true
      }; 
    }
  }
  return null;
}
export function validateDate(control: AbstractControl) {
  
  var eDate = new Date(control.get('end_date').value);
  var sDate = new Date(control.get('start_date').value);
  if(sDate > eDate)
  {
    return  { 'invalid': true }
  }

  return null;
    // const invalid = control.get('start_date').value < control.get('end_date').value;
  // return invalid ? { 'invalidDate': true } : null;
}    


export function ValidateCardNumber(control: AbstractControl) {
  if (control && (control.value !== null || control.value !== undefined)) {

    const regex = new RegExp(constants.CardNumberRegEx);
    // if (!regex.test(control.value)) {
    //   return {
    //    'invalidNumber': true
    //   };
    if (!control.value.toString().match(/^[0-9]{16}$/)) return { 'invalidNumber': true };
    // }
    
  }
  return null;
}

export function ValidateNumber(control: AbstractControl) {
  if (control && (control.value !== null || control.value !== undefined)) {

    if (!control.value.toString().match(/^[+0-9-)( ][-0-9)(]{6,30}$/)) return { 'invalidNumber': true };
  }
  return null;
}

export function ValidatePassword(control: AbstractControl) {
  if (control && (control.value !== null || control.value !== undefined)) {

    if (!control.value.toString().match(/^(?=\D*\d)(?=[^a-z]*[a-z])(?=[^A-Z]*[A-Z]).{8,30}$/)) return { 'invalidPassword': true };

  }
  return null;
}


export function ValidateCVVNumber(control: AbstractControl) {
  if (control && (control.value !== null || control.value !== undefined)) {

    const regex = new RegExp(constants.CvvNumberRegEx);
    // if (!regex.test(control.value)) {
    //   return {
    //     'invalidNumber': true
    //   };

    // }
    if (!control.value.toString().match(/^[0-9]{3}$/)) return { 'invalidNumber': true };
  }
  return null;
}
export function getStartDateAndEndDateofWeekByDate(date: Date) {
  let d = date;
  let monday: string | number | Date = new Date();
  let sunday: string | number | Date = new Date();
  let diffm = d.getDate();
  let diffs = d.getDate();
  console.log(monday);
  console.log(sunday);
  let day = d.getDay();
  if (day != 0) {
    diffm = d.getDate() - day + 1;
    diffs = d.getDate() - day + 7;

  } else {
    diffm = d.getDate() - 6;
    diffs = d.getDate();
  }
  let mon = new Date(d.setDate(diffm));
  let sun = new Date(d.setDate(diffs));
  if (mon.getDate() > sun.getDate()) {
    monday = mon.getFullYear() + '-' + (mon.getMonth() + 1) + '-' + mon.getDate();
    sunday = sun.getFullYear() + '-' + (sun.getMonth() + 2) + '-' + sun.getDate();
  } else {
    monday = mon.getFullYear() + '-' + (mon.getMonth() + 1) + '-' + mon.getDate();
    sunday = sun.getFullYear() + '-' + (sun.getMonth() + 1) + '-' + sun.getDate();
  }
  console.log(monday);
  console.log(sunday);
}
export function sortDatas(data,sortParameters: Sort) {
  const keyName = sortParameters.active;
  if (sortParameters.direction === 'asc') {
    data = data.sort((a, b) => a[keyName].localeCompare(b[keyName]));
  } else if (sortParameters.direction === 'desc') {
    data = data.sort((a, b) => b[keyName].localeCompare(a[keyName]));
  } else {
    return data;
  }
}

