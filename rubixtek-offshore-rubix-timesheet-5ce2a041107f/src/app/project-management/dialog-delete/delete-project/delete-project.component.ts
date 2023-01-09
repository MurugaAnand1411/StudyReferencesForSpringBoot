import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Project } from '../../../shared/model/project';
import { ProjectService } from '../../../service/project/project.service';
import { ToastrService } from 'ngx-toastr';


@Component({
  selector: 'app-delete-project',
  templateUrl: './delete-project.component.html',
  styleUrls: ['./delete-project.component.scss']
})
export class DeleteProjectComponent implements OnInit {
  id: any;
  projectdetails: Project[];
  constructor(private toastr:ToastrService,private projectService: ProjectService,public dialogref: MatDialogRef<DeleteProjectComponent> ,@Inject(MAT_DIALOG_DATA) public data:any, public snackbar:MatSnackBar) { }

  ngOnInit(): void {
    this.id = this.data.id;
    this.getAll()
  }

  getAll(){
    this.projectService.getAll().subscribe((data: Project[])=>{
      console.log(data);
      this.projectdetails=data;
    })
  }

  delete(id:any){
    this.projectService.delete(id).subscribe(data=>{this.getAll();
      
  },err=>{this.toastr.info('Deleted Successfully');this.getAll();});
  this.dialogref.close()
}
 cancelbutton(){
  this.dialogref.close();
  this.toastr.info('Delete Cancelled');
 }
}
