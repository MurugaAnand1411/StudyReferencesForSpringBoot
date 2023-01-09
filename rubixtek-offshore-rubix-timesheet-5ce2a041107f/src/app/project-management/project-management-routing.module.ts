import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LayoutComponent } from '../shared/navigation-contents/layout/layout.component';
import { ProjectDetailsComponent } from './project-details/project-details.component';
import { ProjectUpdateComponent } from './project-update/project-update.component';
import { ViewProjectComponent } from './view-project/view-project.component';

const routes: Routes = [

  {path:"update/add/:id",component:  ProjectUpdateComponent},
  {path:"update/edit/:id",component:  ProjectUpdateComponent},
  {
    path: '',
    component: LayoutComponent,
    children: [
      { path:  "list", component: ProjectDetailsComponent },
    ]
  },
  {
    path: '',
    component: LayoutComponent,
    children: [
      { path:  "view/:projectId", component: ViewProjectComponent },
    ]
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ProjectManagementRoutingModule { }
