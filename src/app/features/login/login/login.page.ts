import {Component, OnInit} from '@angular/core';
import {AbstractControl, FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import {LoginService} from './login.service';
import {OktaAuthService} from '@okta/okta-angular';
import {Router} from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: 'login.page.html',
  styleUrls: ['login.page.scss'],
})
export class LoginPage implements OnInit {

  constructor(private loginService: LoginService, private oktaAuth: OktaAuthService, private router: Router) {}

  public loginGroup: FormGroup;

  public invalidPassword = false;

  ngOnInit() {
    this.loginGroup = new FormGroup({
      username: new FormControl(null, [Validators.required]),
      password: new FormControl(null, [Validators.required])
    });
    this.oktaAuth.isAuthenticated().then((authStatus) => {
      if (authStatus) {
        this.router.navigateByUrl('navbar/chat');
      }
    });
  }

  async submitLogin() {
    await this.oktaAuth.signInWithRedirect({originalUri: 'navbar/chat'});
  }

  get username() {
    return this.loginGroup.get('username');
  }

  get password() {
    return this.loginGroup.get('password');
  }

}
