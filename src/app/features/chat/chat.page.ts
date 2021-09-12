import { Component, OnInit } from '@angular/core';
import {AuthService} from '../../shared/auth/auth.service';

@Component({
  selector: 'app-chat',
  templateUrl: './chat.page.html',
  styleUrls: ['./chat.page.scss'],
})
export class ChatPage implements OnInit {

  friendsSelected = true;

  chatSelected: number;

  constructor(private authService: AuthService) { }

  async ngOnInit() {
    console.log(`Authentication status: ${await this.authService.checkAuthenticated()}`);
    this.authService.getUser().then(result => {
      console.log(`User info: ${JSON.stringify(result)}`);
    });
  }

  onFriendsClicked() {
    if (!this.friendsSelected) {
      this.friendsSelected = !this.friendsSelected;
      this.chatSelected = -1;
    }
  }

  onChatSelected(index: number) {
    this.chatSelected = index;
    this.friendsSelected = false;
  }

}
