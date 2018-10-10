import { Injectable } from '@angular/core';
import { CanActivate, Router} from '@angular/router';
import { Observable } from 'rxjs';
import { AuthenticationService } from '../_services/authentication.service';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {

  constructor(private _authService: AuthenticationService,
    private _router: Router) {}

    
  canActivate(): boolean {
      return true;//if true, can access page
    //
    //   if(this._authService.loggedIn()) {
    //   return true;
    // }else {
    //   this._router.navigate(['/login']);
    //   return false;
    // }
  }
}
