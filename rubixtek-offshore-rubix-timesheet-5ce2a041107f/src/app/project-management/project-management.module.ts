import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ProjectManagementRoutingModule } from './project-management-routing.module';
import { ProjectDetailsComponent } from './project-details/project-details.component';
import { ProjectUpdateComponent } from './project-update/project-update.component';
import { SharedModule } from '../shared/shared.module';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { DeleteProjectComponent } from './dialog-delete/delete-project/delete-project.component';
import { ViewProjectComponent } from './view-project/view-project.component';


@NgModule({
  declarations: [
    ProjectDetailsComponent,DeleteProjectComponent,
    ProjectUpdateComponent,
    ViewProjectComponent
  ],
  imports: [
    CommonModule,
    ProjectManagementRoutingModule,
    SharedModule
  ],
  providers: [
    { provide: MAT_DIALOG_DATA, useValue: {} },
    { provide: MatDialogRef, useValue: {} }
  ]

})
export class ProjectManagementModule { }
