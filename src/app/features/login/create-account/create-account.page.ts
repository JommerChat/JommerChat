import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-create-account',
  templateUrl: './create-account.page.html',
  styleUrls: ['./create-account.page.scss'],
})
export class CreateAccountPage implements OnInit {

  public createAccountGroup: FormGroup;
  public hidePassword = true;

  constructor() { }

  ngOnInit() {
    this.createAccountGroup = new FormGroup({
      email: new FormControl('name@email.com', [Validators.required, Validators.email]),
      username: new FormControl(null, [Validators.required]),
      password: new FormControl(null, [Validators.required, Validators.minLength(6)]),
      repeatPassword: new FormControl(null, [Validators.required])
    });
  }

  changePasswordView() {
    this.hidePassword = !this.hidePassword;
  }

}
