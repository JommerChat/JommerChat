import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-channels',
  templateUrl: './channels.component.html',
  styleUrls: ['./channels.component.scss']
})
export class ChannelsComponent implements OnInit {

  guildName = 'Test Name';
  channelHeaderMenuOpen = false;

  textChannels = [
    {
      id: 1234,
      created_at: new Date(),
      guild_id: 1234,
      title: 'general',
      description: 'General chat',
      categoryId: '',
      position: 1,
      selected: true
    },
    {
      id: 12345,
      created_at: new Date(),
      guild_id: 1234,
      title: 'memes',
      description: 'Meme channel',
      categoryId: '',
      position: 0,
      selected: false
}];

  constructor() { }

  ngOnInit() {
    this.sortChannelsByPosition();
  }

  onChannelClicked(position: number) {
    console.log(`Channel clicked with position: ${position}`);
    this.textChannels.find(s => s.selected === true).selected = false;
    this.textChannels.find(s => s.position === position).selected = true;
    console.log(`Value of textChannels objects: ${JSON.stringify(this.textChannels)}`);
  }

  sortChannelsByPosition() {
    this.textChannels.sort((a, b) => a.position - b.position);
  }

  channelHeaderClicked() {
    this.channelHeaderMenuOpen = !this.channelHeaderMenuOpen;
  }

}
