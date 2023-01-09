import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { ProjectService } from 'src/app/service/project/project.service';
import { Project } from 'src/app/shared/model/project';

@Component({
  selector: 'app-view-project',
  templateUrl: './view-project.component.html',
  styleUrls: ['./view-project.component.scss']
})
export class ViewProjectComponent implements OnInit {
  id: any;
project:Project;
  constructor(private router: Router,private route: ActivatedRoute, private projectService: ProjectService,) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['projectId'];
    this.getById();
  }
  getById(){
    this.projectService.getById(this.id).subscribe(data=>{this.project=data;console.log(data)});
  }
}
