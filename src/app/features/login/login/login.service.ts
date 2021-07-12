import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {AuthResponse} from './auth-response';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  readonly AUTHENDPOINTURL = 'localhost:8080/auth';

  constructor(private httpClient: HttpClient) { }

  public submitCredentials(username: string, password: string): Observable<AuthResponse> {
    const body = {
      username,
      password
    };
    return this.httpClient.post<AuthResponse>(this.AUTHENDPOINTURL, body);
  }

}
