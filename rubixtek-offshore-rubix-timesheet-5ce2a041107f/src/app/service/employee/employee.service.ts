import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from 'src/app/shared/model/user';
import { environment } from 'src/environments/environment';
import { AuthService } from '../auth/auth.service';
@Injectable({
  providedIn: 'root'
})
export class EmployeeService {
  apiUrl = environment.apiUrl;
  private addTimesheetByEmpId = this.apiUrl + '/timesheet/rubix/employee/addTimesheet';
  private updateTimesheetById=this.apiUrl+'/timesheet/rubix/employee/updateTimesheet';
  private getTimesheetByEmpId = this.apiUrl + '/timesheet/rubix/employee/getTimesheetByEmployeeId';
  private getTimesheetByTimesheetId=this.apiUrl+'/timesheet/rubix/employee/getTimesheetById'
  private deleteTimesheet=this.apiUrl+'/timesheet/rubix/employee/deleteTimesheet'
  private addTaskById=this.apiUrl+'/timesheet/rubix/employee/addTaskDetail';
  private updateTaskDetail=this.apiUrl+'/timesheet/rubix/employee/updateTaskDetail'
  private getTaskByTaskId=this.apiUrl+'/timesheet/rubix/employee/getTaskDetailById';
  private getApproval=this.apiUrl+'/timesheet/rubix/employee/submitForApproval';
  private getEmployeeById=this.apiUrl+'/timesheet/rubix/employee/details';
  private getAllAdmin=this.apiUrl+'/timesheet/rubix/employee/getAllAdmin';
  constructor(private http: HttpClient, private authService: AuthService) { }
  addNewTimesheet(timesheet: any): Observable<any> {
    return this.http.post(`${this.addTimesheetByEmpId}/?employeeId=${this.authService.currentUserValue.id}`, timesheet);
  }
  updateTimesheet(timesheet: any,timeSheetId:any): Observable<any> {
    return this.http.post(`${this.updateTimesheetById}/?employeeId=${this.authService.currentUserValue.id}&timesheetId=${timeSheetId}`, timesheet);
  }
  getAllTimesheetByEmpId(): Observable<any> {
    return this.http.get(`${this.getTimesheetByEmpId}/${this.authService.currentUserValue.id}`);
  }
  getTimesheetById(timeSheetId:any): Observable<any> {
    return this.http.get(`${this.getTimesheetByTimesheetId}/${timeSheetId}`);
  }
  getTaskById(taskId:any): Observable<any> {
    return this.http.get(`${this.getTaskByTaskId}/${taskId}`);
  }
  deleteTimesheetById(timeSheetId:any): Observable<any> {
    return this.http.delete(`${this.deleteTimesheet}/${timeSheetId}`);
  }
  addTaskdetails(taskDetail:any,timesheedId:any): Observable<any>{
    return this.http.post(`${this.addTaskById}/?timesheetId=${timesheedId}`, taskDetail,{responseType:'text'} );
  }
  
  editTaskDetail(taskDetail:any,timesheedId:any,taskDetailId:any){
    return this.http.put(`${this.updateTaskDetail}/?timesheetId=${timesheedId}&timesheetDetailId=${taskDetailId}`, taskDetail)
  }
  submitForApproval(timesheedId:any,taskDetailId:any,totalhours:any): Observable<any>{
    return this.http.get(`${this.getApproval}?timesheetId=${timesheedId}&timesheetDetailId=${taskDetailId}&billableHours=${totalhours}`);
  }
  getEmpById(employeeId:any):Observable<any>{
    return this.http.get(`${this.getEmployeeById}/${employeeId}`);
  }
  getAllAdmins(): Observable<any> {
    return this.http.get(`${this.getAllAdmin}`);
  }
}
