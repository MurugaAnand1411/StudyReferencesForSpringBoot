import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Project } from '../../shared/model/project';

@Injectable({
  providedIn: 'root'
})
export class ProjectService {
  
  private apiServer = "http://localhost:8081/project";
  
httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json'
  })
}

constructor(private httpclient:HttpClient) { }


getAll():Observable<any[]>{
  return this.httpclient.get<any[]>(this.apiServer + '/getprojectlist');
}
add(projectdetails: Project):Observable<any>{
  return this.httpclient.post<any>(this.apiServer + '/createproject', JSON.stringify(projectdetails), this.httpOptions);
}
update(id:any,projectdetails:any):Observable<any>{
  return this.httpclient.put<any>(this.apiServer + '/updateproject/' + id ,JSON.stringify(projectdetails), this.httpOptions);
}
getById(id:number):Observable<any> {
  return this.httpclient.get<any>(this.apiServer + '/getprojectbyid/' + id)
}
delete(id:number){
  return this.httpclient.delete<any>(this.apiServer + '/deleteprojectbyid/' + id, this.httpOptions);
}
}