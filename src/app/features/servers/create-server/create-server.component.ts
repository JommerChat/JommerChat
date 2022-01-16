import {Component, OnInit, ViewChild} from '@angular/core';
import {FileChangeEvent} from '@angular/compiler-cli/src/perform_watch';
import {FormControl, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-create-server',
  templateUrl: './create-server.component.html',
  styleUrls: ['./create-server.component.scss'],
})
export class CreateServerComponent implements OnInit {

  publicServerFlag = false;

  createServerDisplayed = true;
  joinServerDisplayed = false;

  serverFormGroup: FormGroup;


  constructor() { }

  ngOnInit() {
    this.serverFormGroup = new FormGroup({
      serverName: new FormControl(null, [Validators.required, Validators.maxLength(50)]),
      serverDescription: new FormControl(null, [Validators.maxLength(250)]),
    });
  }

  createAServerClicked() {
    this.createServerDisplayed = true;
  }

  customizeServerBackClicked() {
    this.createServerDisplayed = false;
  }

  onFileChange(event: Event) {
    // do file stuff here
  }

  get serverName() {
    return this.serverFormGroup.get('serverName');
  }

  get serverDescription() {
    return this.serverFormGroup.get('serverDescription');
  }

}
