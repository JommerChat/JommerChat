import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {LoginService} from './login.service';
import {Router} from '@angular/router';
import {AuthService} from '../../../shared/auth/auth.service';

@Component({
  selector: 'app-home',
  templateUrl: 'login.page.html',
  styleUrls: ['login.page.scss'],
})
export class LoginPage implements OnInit {

  constructor(private loginService: LoginService, private router: Router, private authService: AuthService) {}

  public loginGroup: FormGroup;

  public invalidPassword = false;
  submitInProgress = false;

  async ngOnInit() {
    this.submitInProgress = false;
    this.loginGroup = new FormGroup({
      username: new FormControl(null, [Validators.required]),
      password: new FormControl(null, [Validators.required])
    });
    console.log('Executed login page ngOnInit');
    if (this.authService.authClient.isLoginRedirect()) {
      this.authService.authClient.token.parseFromUrl()
        .then(data => {
          console.log(`Contents of parseFromUrl are: ${JSON.stringify(data)}`);
          this.authService.authClient.tokenManager.add('idToken', data.tokens.idToken);
          this.authService.authClient.tokenManager.add('accessToken', data.tokens.accessToken);
        });
    }
    if (await this.authService.checkAuthenticated()) {
      await this.router.navigateByUrl('navbar/chat');
    }
  }

  async submitLogin() {
    try {
      this.submitInProgress = true;
      await this.authService.login(this.username.value, this.password.value);
    } catch (error) {
      this.invalidPassword = true;
      this.submitInProgress = false;
    }
  }

  get username() {
    return this.loginGroup.get('username');
  }

  get password() {
    return this.loginGroup.get('password');
  }

}
