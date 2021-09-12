import { Injectable } from '@angular/core';
import {OktaAuth, UserClaims} from '@okta/okta-auth-js';
import {environment} from '../../../environments/environment';
import {BehaviorSubject} from 'rxjs';
import {Router} from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  public authClient = new OktaAuth({
    issuer: environment.issuer,
    clientId: environment.clientId,
    redirectUri: environment.redirectUri
  });

  public isAuthenticated = new BehaviorSubject<boolean>(false);

  constructor(private router: Router) {
    this.authClient.start();
  }

  async checkAuthenticated(): Promise<boolean> {
    const authenticated = await this.authClient.session.exists();
    this.isAuthenticated.next(authenticated);
    return authenticated;
  }

  getAccessToken(): string {
    return this.authClient.getAccessToken();
  }

  async getUser(): Promise<UserClaims> {
    return this.authClient.getUser();
  }

  async login(username: string, password: string): Promise<void> {
    const transaction = await this.authClient.signInWithCredentials({username, password});
    if (transaction.status !== 'SUCCESS') {
      throw Error(`Authentication error occurred with status: ${transaction.status}`);
    }
    this.isAuthenticated.next(true);
    await this.authClient.token.getWithRedirect({
      sessionToken: transaction.sessionToken,
      responseType: 'id_token'
    });
  }

  async logout(redirect: string): Promise<void> {
    try {
      await this.authClient.signOut();
      this.isAuthenticated.next(false);
      await this.router.navigate([redirect]);
    } catch (error) {
      console.error(error);
    }
  }
}
