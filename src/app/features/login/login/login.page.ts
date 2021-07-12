import {Component, OnInit} from '@angular/core';
import {AbstractControl, FormBuilder, FormControl, FormGroup} from '@angular/forms';
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

  ngOnInit() {
    this.loginGroup = new FormGroup({
      username: new FormControl(),
      password: new FormControl()
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

}
