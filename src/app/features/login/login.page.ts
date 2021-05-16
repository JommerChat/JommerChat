import {Component, OnInit} from '@angular/core';
import {AbstractControl, FormBuilder, FormControl, FormGroup} from '@angular/forms';
import {LoginService} from './login.service';

@Component({
  selector: 'app-home',
  templateUrl: 'login.page.html',
  styleUrls: ['login.page.scss'],
})
export class LoginPage implements OnInit {

  constructor(private loginService: LoginService) {}

  public loginGroup: FormGroup;

  ngOnInit() {
    this.loginGroup = new FormGroup({
      username: new FormControl(),
      password: new FormControl()
    });
  }

  submitLogin() {
    const username = this.loginGroup.get('username') as AbstractControl;
    const password = this.loginGroup.get('password') as AbstractControl;
    this.loginService.submitCredentials(username.value, password.value);
    console.log('Login submitted');
  }

}
