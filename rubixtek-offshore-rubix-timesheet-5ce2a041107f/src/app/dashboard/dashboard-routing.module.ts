import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AdminAuthGuard } from '../shared/guards/admin.guard';
import { LayoutComponent } from '../shared/navigation-contents/layout/layout.component';
import { HomeComponent } from './home/home.component';
const routes: Routes = [
{
  path: '',
  component: LayoutComponent,
  children: [
    // { path: '', component: HomeComponent,canActivate: [AdminAuthGuard] },
    { path: '', component: HomeComponent },
  ]
},

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class DashboardRoutingModule { }
