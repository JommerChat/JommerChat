import { Injectable } from '@angular/core';
import {HttpEvent, HttpHandler, HttpInterceptor, HttpRequest} from '@angular/common/http';
import {Observable} from 'rxjs';
import {AuthService} from './auth.service';

@Injectable({
  providedIn: 'root'
})
export class AuthInterceptorService implements HttpInterceptor {

  constructor(private authService: AuthService) { }

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    console.log('Intercepting request and injecting token: ' + this.authService.getAccessToken());
    req = req.clone({
      setHeaders: {
        Authorization: `Bearer ${this.authService.getAccessToken()}`
      },
    });

    return next.handle(req);
  }
}
