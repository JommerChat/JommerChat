import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormControl, FormGroup} from '@angular/forms';

@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss'],
})
export class HomePage implements OnInit {

  constructor() {}

  public loginGroup: FormGroup;

  ngOnInit() {
    this.loginGroup = new FormGroup({
      username: new FormControl(),
      password: new FormControl()
    });
  }

  submitLogin() {
    console.log('Login submitted');
  }

}
