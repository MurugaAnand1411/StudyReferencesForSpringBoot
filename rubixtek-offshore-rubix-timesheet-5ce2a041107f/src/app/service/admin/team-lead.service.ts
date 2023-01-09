import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Employee } from 'src/app/shared/model/employee';
import { environment } from 'src/environments/environment';
import { AuthService } from '../auth/auth.service';

@Injectable({
  providedIn: 'root'
})
export class TeamLeadService {
  apiUrl = environment.apiUrl;
  private getTimesheet=this.apiUrl+'/timesheet/rubix/admin/getPendingTimesheet';
  private getTimesheetByTimesheetId=this.apiUrl+'/timesheet/rubix/admin/getTimesheetwithEmpId'
  private getApprovalTimesheet=this.apiUrl+'/timesheet/rubix/admin/approveTimesheet';
  private getRejectTimesheet=this.apiUrl+'/timesheet/rubix/admin/rejectTimesheet';
  private getAllEmployeeDetails=this.apiUrl+'/timesheet/rubix/admin/getAllEmployees';
  private getAllAdmin=this.apiUrl+'/timesheet/rubix/admin/getAllAdmin';
  private getPendingCounts=this.apiUrl+'/timesheet/rubix/admin/getAllPendingCounts';
  private getApprovedTimesheet=this.apiUrl+'/timesheet/rubix/admin/geApprovedAndRejectedTimesheet';
  private updateEmployee=this.apiUrl+'/timesheet/rubix/admin/updateEmployee';
  private addNewEmployee=this.apiUrl+'/timesheet/rubix/admin/addEmployee';
  private deleteExistEmployee=this.apiUrl+'/timesheet/rubix/admin/deleteEmployee';
  private updateSupervisor=this.apiUrl+'/timesheet/rubix/admin/updateSupervisor';
  private updateRoles=this.apiUrl+'/timesheet/rubix/admin/updateRoles';
  constructor(private http: HttpClient, private authService: AuthService) { }

  getAllTimesheetForApproval(): Observable<any> {
    return this.http.get(`${this.getTimesheet}`);
  }
  getAllApprovedTimesheet(start_date:Date,end_date:Date): Observable<any> {
    return this.http.get(`${this.getApprovedTimesheet}/${start_date}/${end_date}`);
  }
  getTimesheetById(timeSheetId:any): Observable<any> {
    return this.http.get(`${this.getTimesheetByTimesheetId}/${timeSheetId}`);
  }
  approveTimesheetById(timeSheetId:any): Observable<any> {
    return this.http.get(`${this.getApprovalTimesheet}/${timeSheetId}`);
  }
  rejectTimesheetById(timeSheetId:any): Observable<any> {
    return this.http.get(`${this.getRejectTimesheet}/${timeSheetId}`);
  }
  getAllEmployees(): Observable<any> {
    return this.http.get(`${this.getAllEmployeeDetails}`);
  }
  getAllAdmins(): Observable<any> {
    return this.http.get(`${this.getAllAdmin}`);
  }
  getAllPendingCount(): Observable<any> {
    return this.http.get(`${this.getPendingCounts}`);
  }
  editEmployee(employeeId:any,employee:Employee): Observable<any> {
    return this.http.post(`${this.updateEmployee}/${employeeId}`,employee);
  }
  addEmployee(employee:any,roles:any): Observable<any> {
    return this.http.post(`${this.addNewEmployee}?role=${roles}`,employee);
  }
  deleteEmployee(employeeId:any): Observable<any> {
    return this.http.delete(`${this.deleteExistEmployee}/${employeeId}`);
  }
  editSupervisor(employeeId:any,supervisorId:any,employee:Employee): Observable<any> {
    return this.http.post(`${this.updateSupervisor}/${employeeId}/${supervisorId}`,employee);
  }
  editRoles(employeeId:any,roles:any,employee:Employee): Observable<any> {
    return this.http.post(`${this.updateRoles}/${employeeId}?rolesName=${roles}`,employee);
  }
}
