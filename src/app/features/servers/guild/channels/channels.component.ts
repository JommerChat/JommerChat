import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-channels',
  templateUrl: './channels.component.html',
  styleUrls: ['./channels.component.scss']
})
export class ChannelsComponent implements OnInit {

  guildName = 'Test Name';

  textChannels = [
    {
    id: 1234,
    created_at: new Date(),
    guild_id: 1234,
    title: 'general',
    description: 'General chat',
    categoryId: '',
    position: 0
    },
    {
    id: 1234,
    created_at: new Date(),
    guild_id: 1234,
    title: 'memes',
    description: 'Meme channel',
    categoryId: '',
    position: 1
}];

  constructor() { }

  ngOnInit() {}

}
