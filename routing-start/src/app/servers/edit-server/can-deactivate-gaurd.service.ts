import { CanDeactivate, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';
import { Observable } from 'rxjs';
export interface CanComponentDeactivate {
  canDeactive: ()=>boolean | Observable<boolean> | Promise<boolean>;
}


export class CanDeactivateGaurd implements CanDeactivate<CanComponentDeactivate>{
  
  canDeactivate(component: CanComponentDeactivate, currentRoute: ActivatedRouteSnapshot, currentState: RouterStateSnapshot, nextState?: RouterStateSnapshot): boolean | Observable<boolean> | Promise<boolean> {
   return component.canDeactive();
  }

}