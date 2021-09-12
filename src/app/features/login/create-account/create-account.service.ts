import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CreateAccountService {

  constructor(private httpClient: HttpClient) { }

  registerUrl = 'https://api.parlantos.com/auth/register';

  registerUser(email: string, username: string, password: string) {
    const body = {
      email,
      username,
      password
    };
    return this.httpClient.post(this.registerUrl, body, {responseType: 'text'});
  }
}
