import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-chat',
  templateUrl: './chat.page.html',
  styleUrls: ['./chat.page.scss'],
})
export class ChatPage implements OnInit {

  friendsSelected = true;

  chatSelected: number;

  constructor() { }

  ngOnInit() {
  }

  onFriendsClicked() {
    this.friendsSelected = !this.friendsSelected;
  }

  onChatSelected(index: number) {
    this.chatSelected = index;
  }

}
