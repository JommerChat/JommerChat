import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-members',
  templateUrl: './members.component.html',
  styleUrls: ['./members.component.scss'],
})
export class MembersComponent implements OnInit {

  members: Array<{ icon: string, username: string; }> = [];

  constructor() {
    let icon = 'https://cdn.discordapp.com/avatars/304475016936816640/a_7cde5bfd9549b15e98d17eb24d758593.webp?size=96';
    let username = 'HaZe (Jom)';
    this.members.push({icon, username});
    icon = 'https://cdn.discordapp.com/avatars/326546102537158666/7f2ade2fd4f415e307aa277e0e2b137b.webp?size=96';
    username = 'Annual';
    this.members.push({icon, username});
  }

  ngOnInit() {}

}
