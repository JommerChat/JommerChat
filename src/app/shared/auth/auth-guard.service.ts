import { Injectable } from '@angular/core';
import {CanActivate, Router} from '@angular/router';
import {AuthService} from './auth.service';
import {environment} from '../../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class AuthGuardService implements CanActivate {

  constructor(public authService: AuthService, public router: Router) { }

  async canActivate(): Promise<boolean> {
    if (!await this.authService.checkAuthenticated()) {
      await this.router.navigate(['login']);
      return false;
    }
    return true;
  }
}
