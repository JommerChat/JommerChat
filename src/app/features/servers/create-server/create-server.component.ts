import { Component, OnInit } from '@angular/core';
import {FileChangeEvent} from '@angular/compiler-cli/src/perform_watch';
import {FormControl, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-create-server',
  templateUrl: './create-server.component.html',
  styleUrls: ['./create-server.component.scss'],
})
export class CreateServerComponent implements OnInit {

  createServerDisplayed = true;
  joinServerDisplayed = false;

  serverFormGroup: FormGroup;

  constructor() { }

  ngOnInit() {
    this.serverFormGroup = new FormGroup({
      serverName: new FormControl(null, [Validators.required]),
      serverDescription: new FormControl(null)
    });
  }

  createAServerClicked() {
    this.createServerDisplayed = true;
  }

  onFileChange(event: Event) {
    // do file stuff here
  }

}
