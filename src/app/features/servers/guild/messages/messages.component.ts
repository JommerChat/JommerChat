import {Component, Input, OnInit} from '@angular/core';
import {Messages} from '../../../../shared/models/Messages';

@Component({
  selector: 'app-messages',
  templateUrl: './messages.component.html',
  styleUrls: ['./messages.component.scss'],
})
export class MessagesComponent implements OnInit {

  @Input() messages: Messages[];


  constructor() { }

  ngOnInit() {}

}
