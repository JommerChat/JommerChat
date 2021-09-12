import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {CreateAccountService} from './create-account.service';
import {Subscription} from 'rxjs';
import {AuthService} from '../../../shared/auth/auth.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-create-account',
  templateUrl: './create-account.page.html',
  styleUrls: ['./create-account.page.scss'],
})
export class CreateAccountPage implements OnInit {

  public registerObservable$: Subscription;
  public createAccountGroup: FormGroup;
  public hidePassword = true;
  public meetsPasswordComplexity = true;

  constructor(private createAccountService: CreateAccountService, private authService: AuthService, private router: Router) { }

  async ngOnInit() {
    this.createAccountGroup = new FormGroup({
      email: new FormControl('name@email.com', [Validators.required, Validators.email]),
      username: new FormControl(null, [Validators.required]),
      password: new FormControl(null, [Validators.required, Validators.minLength(6)]),
      repeatPassword: new FormControl(null, [Validators.required])
    });
    if (await this.authService.checkAuthenticated()) {
      await this.router.navigateByUrl('navbar/chat');
    }
  }

  changePasswordView() {
    this.hidePassword = !this.hidePassword;
  }

  async registerUser() {
    this.registerObservable$ = this.createAccountService.registerUser(this.createAccountGroup.get('email').value,
      this.createAccountGroup.get('username').value, this.createAccountGroup.get('password').value).subscribe((result) => {
        this.meetsPasswordComplexity = true;
        console.log('Logging result from request: ' + JSON.stringify(result));
        this.submitLogin();
    }, (error) => {
        console.log(`Error object value: {}`, JSON.stringify(error));
        if (error.error.includes('Okta E0000001')) {
          this.meetsPasswordComplexity = false;
        }
    });
  }

  async submitLogin() {
    await this.authService.login(this.createAccountGroup.get('email').value, this.createAccountGroup.get('password').value);
  }

}
