import { Component, Inject, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, NgForm, Validators } from '@angular/forms';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRoute, Router } from '@angular/router';
import { Project } from '../../shared/model/project';
import { ProjectService } from '../../service/project/project.service';
import { ProjectDetailsComponent } from '../project-details/project-details.component';
import { formatDate } from '@angular/common';
import { parse } from 'date-fns';
@Component({
  selector: 'app-project-update',
  templateUrl: './project-update.component.html',
  styleUrls: ['./project-update.component.scss']
  
})
export class ProjectUpdateComponent implements OnInit {
  form: FormGroup;
  editmode:boolean=false;
  id: any;
  header: string;
  projectdetails:Project = {
    projectId:"",
    clientName:"",
    projectName:"",
    projectType:"",
    projectDescription:"",
    projectManager:"",
    startDate:"",
    endDate:""
  };

  constructor(private _fb: FormBuilder,private router: Router,private route: ActivatedRoute, private projectService: ProjectService, public dialogref: MatDialogRef<ProjectDetailsComponent> ,@Inject(MAT_DIALOG_DATA) public data:any, public snackbar:MatSnackBar) {}

  ngOnInit(): void {
    this.form = this._fb.group({
      clientName : ["",[Validators.required]],
      projectName: ["",[Validators.required]],
      projectType: ["",[Validators.required]],
      projectDescription: ["",Validators.required],
      projectManager : ["",[Validators.required]],
      startDate: ["",Validators.required],
      endDate: ["",Validators.required]
    
  })
    this.id = this.data.id;
    if(this.id !=0){
      this.GetbyId();
      this.editmode=true;
      this.header="Edit project"
    }
    else{
      this.editmode=false;
      this.header="Add project"
    }

  }
  
  GetbyId(){
    this.projectService.getById(this.id).subscribe(data=>{this.form.patchValue(data);
      this.form.controls['startDate'].setValue(parse(data.startDate, 'dd/MM/yyyy', new Date()));
      this.form.controls['endDate'].setValue(parse(data.endDate, 'dd/MM/yyyy', new Date()))
    });
  }
  onSubmit(form: FormGroup){
    
    if(this.editmode){
      this.form.controls['startDate'].setValue(formatDate(this.form.controls['startDate'].value,'dd/MM/yyyy','en-GB'));
      this.form.controls['endDate'].setValue(formatDate(this.form.controls['endDate'].value,'dd/MM/yyyy','en-GB'));
      this.projectService.update(this.id,this.form.value).subscribe();
      this.snackbar.open('successfully updated', ' ', {
        duration: 3000,
      });
      this.dialogref.close()
    }
    else{
      this.form.controls['startDate'].setValue(formatDate(this.form.controls['startDate'].value,'dd/MM/yyyy','en-GB'));
      this.form.controls['endDate'].setValue(formatDate(this.form.controls['endDate'].value,'dd/MM/yyyy','en-GB'));
      this.projectService.add(this.form.value).subscribe();
      this.snackbar.open('successfully added' ,' ', {
        duration: 3000,
      });
      this.dialogref.close()
    }
    console.log(form.value);
  }
  cancel(){
    this.dialogref.close()
}

}
