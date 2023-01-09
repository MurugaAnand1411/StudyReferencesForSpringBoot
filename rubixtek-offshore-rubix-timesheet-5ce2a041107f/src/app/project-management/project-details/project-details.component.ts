import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { DeleteProjectComponent } from './../dialog-delete/delete-project/delete-project.component';
import { Project } from '../../shared/model/project';
import { ProjectService } from '../../service/project/project.service';
import { ProjectUpdateComponent } from '../project-update/project-update.component';
import { Sort } from '@angular/material/sort';
import { sortDatas } from 'src/app/shared/util';
import { Router } from '@angular/router';


@Component({
  selector: 'app-project-details',
  templateUrl: './project-details.component.html',
  styleUrls: ['./project-details.component.scss']

})

export class ProjectDetailsComponent implements OnInit {

  projectdetails: Project[];
  tableColumns: { name: string; dataKey: string; isSortable: boolean; }[];
  constructor(private router: Router, private projectService: ProjectService, private dialog: MatDialog) { }

  ngOnInit(): void {
    this.getAll();
    this.initColums();
  }
  getAll() {
    this.projectService.getAll().subscribe((data: Project[]) => {
      console.log(data);
      this.projectdetails = data;

    })
  }
  editDialog(projectid: any) {
    const dialogRef = this.dialog.open(ProjectUpdateComponent, {
      width: '660px',
      height: '560px',
      data: { id: projectid }
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log(`Dialog result: ${result}`);
      this.getAll()
    });
  }
  viewProject(id: any) {
    this.router.navigate(['/project/view', id]);
  }
  deleteDialog(projectid: any) {
    const dialogRef = this.dialog.open(DeleteProjectComponent, {
      width: '300px',
      height: '200px',
      data: { id: projectid }

    });
    dialogRef.afterClosed().subscribe(result => {
      console.log(`Dialog result: ${result}`);
      this.getAll()
    });
  }
  initColums(): void {
    this.tableColumns = [
      {
        name: 'Id',
        dataKey: 'projectId',
        isSortable: true
      },
      {
        name: 'Client Name',
        dataKey: 'clientName',
        isSortable: true
      },
      {
        name: 'Project Name',
        dataKey: 'projectName',
        isSortable: true
      },
      {
        name: 'Project Manager',
        dataKey: 'projectManager',
        isSortable: true
      },

    ];
  }
  sort(sortParameters: Sort) {
    sortDatas(this.projectdetails, sortParameters);
  }
}