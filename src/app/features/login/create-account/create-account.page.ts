import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';

@Component({
  selector: 'app-create-account',
  templateUrl: './create-account.page.html',
  styleUrls: ['./create-account.page.scss'],
})
export class CreateAccountPage implements OnInit {

  public createAccountGroup: FormGroup;

  constructor() { }

  ngOnInit() {
    this.createAccountGroup = new FormGroup({
      email: new FormControl(),
      username: new FormControl(),
      password: new FormControl(),
      repeatPassword: new FormControl()
    });
  }

}
