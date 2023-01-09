import { Injectable } from '@angular/core';
import { Router, CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';
import { AuthService } from '../../service/auth/auth.service';

@Injectable()
export class AuthGuard implements CanActivate {

    constructor(public authService: AuthService, private router: Router) { }

    canActivate(): boolean {
        if (!this.authService.getIsLogged) {
          this.router.navigate(['/']);
          return false;
        }
        return true;
      }

    
}    

