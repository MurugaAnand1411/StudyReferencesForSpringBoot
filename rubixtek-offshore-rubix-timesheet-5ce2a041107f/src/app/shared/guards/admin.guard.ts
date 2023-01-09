import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { AuthService } from 'src/app/service/auth/auth.service';

@Injectable()
export class AdminAuthGuard implements CanActivate {
  constructor(private router: Router,private authService:AuthService) {

  }

  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean> | Promise<boolean> | boolean {
    //   if (localStorage.getItem('currentUser') != null && this.authService.IsAdmin) {
    //     return true;
    //   }
    //  this.router.navigate(['/']);
    //  return false;
    if (this.authService.getIsLogged && this.authService.IsAdmin) {
      return true;
      
    }
    this.router.navigate(['/']);
    return false;
  }
}
