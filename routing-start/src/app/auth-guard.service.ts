import { AuthService } from './auth.service';
import { Injectable } from '@angular/core';
import { CanActivate, RouterStateSnapshot, ActivatedRouteSnapshot, Router, CanActivateChild } from '@angular/router';
import { Observable } from 'rxjs-compat';

@Injectable()
export class AuthGaurd implements CanActivate, CanActivateChild {
  canActivateChild(childRoute: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean | Observable<boolean> | Promise<boolean> {
     return this.canActivate(childRoute,state);
  }

  
  constructor(private authService: AuthService, private router: Router){}
  
  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean | Observable<boolean> | Promise<boolean> {
    
   return this.authService.isAuthenicated().then(
      (authenticated:boolean)=>{
          if(authenticated){
            return true;
          }else{
            this.router.navigate(['/']);
          }
      }
    );
    
  }

}