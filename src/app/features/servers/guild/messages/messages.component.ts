import {AfterViewInit, Component, Input, OnDestroy, OnInit, ViewChild, ViewChildren} from '@angular/core';
import {Messages} from '../../../../shared/models/Messages';
import {FormControl, FormGroup} from '@angular/forms';
import {IonGrid, IonTextarea} from '@ionic/angular';
import {Subscription} from 'rxjs';

@Component({
  selector: 'app-messages',
  templateUrl: './messages.component.html',
  styleUrls: ['./messages.component.scss'],
})
export class MessagesComponent implements OnInit, AfterViewInit, OnDestroy {

  @Input() messages: Messages[];

  @ViewChild(IonTextarea) ionTextArea;
  @ViewChild(HTMLTextAreaElement) textArea;
  @ViewChildren(IonGrid) ionGrid;

  inputFormGroup: FormGroup;

  gridHeight: number;
  originalGridHeight: number;

  previousScrollHeight = 74;

  gridViewChildrenSubscription: Subscription;

  constructor() { }

  ngOnInit() {
    this.inputFormGroup = new FormGroup({
      inputBox: new FormControl('')
    });
  }

  ngAfterViewInit() {
    this.ionGrid.changes.subscribe(result => {
      this.originalGridHeight = result.first.el.offsetHeight;
    });
  }

  ngOnDestroy() {
    this.gridViewChildrenSubscription?.unsubscribe();
  }

  getMessage() {
    return this.inputFormGroup.get('inputBox');
  }

  sendMessage() {
    // TODO: actually send the message to the server and add the message to the messages object
    console.debug('Sending messages');
  }

  autoGrowTextArea() {
    console.log(this.ionTextArea.el.style.lineHeight);
    const scrollHeight = this.ionTextArea.el.scrollHeight;
    if (scrollHeight < this.previousScrollHeight) {
      this.gridHeight = this.originalGridHeight;
    }
    else if (this.ionTextArea.el.offsetHeight >= 139) {
      this.ionTextArea.el.style.overflow = 'auto';
    }
    else if (this.previousScrollHeight !== scrollHeight) {
      this.ionTextArea.el.style.height = '0px';
      this.ionTextArea.el.style.height = scrollHeight + 'px';
      this.gridHeight = this.ionGrid.el.offsetHeight - (scrollHeight - 72);
      this.previousScrollHeight = scrollHeight;
    }
  }


}
