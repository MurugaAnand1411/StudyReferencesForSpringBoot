import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import{TopNavigationComponent} from '../shared/navigation-contents/top-navigation/top-navigation.component'
const routes: Routes = [
  // { path: '', component: LoginComponent },

  {
    path: '',
    component: TopNavigationComponent,
    children: [
      { path: '', component: LoginComponent },
    ]
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AuthRoutingModule { }
