import {Component, OnDestroy, OnInit} from '@angular/core';
import {GuildService} from '../guild.service';
import {Subscription} from 'rxjs';
import {ActivatedRoute, Router} from '@angular/router';
import {TextChannel} from '../../../../shared/models/TextChannel';
import {Messages} from '../../../../shared/models/Messages';

@Component({
  selector: 'app-channels',
  templateUrl: './channels.component.html',
  styleUrls: ['./channels.component.scss']
})
export class ChannelsComponent implements OnInit, OnDestroy {

  guildName = 'Test Name';
  channelHeaderMenuOpen = false;
  guildId = '';
  paramMapSubscription: Subscription;
  messagesForCurrentChannel: Messages[];

  textChannels: TextChannel[] = [
    {
      id: '1234',
      createdAt: new Date().toDateString(),
      guildEntity: {
        id: '1234',
        createdAt: new Date().toDateString(),
        name: 'Siege Pros',
      },
      title: 'general',
      description: 'General chat',
      categoryId: '',
      position: 1,
      selected: true
    },
    {
      id: '12345',
      createdAt: new Date().toDateString(),
      guildEntity: {
        id: '1234',
        createdAt: new Date().toDateString(),
        name: 'Siege Pros',
      },
      title: 'memes',
      description: 'Meme channel',
      categoryId: '',
      position: 0,
      selected: false
}];

  constructor(private guildService: GuildService, private route: ActivatedRoute, private router: Router) { }

  ngOnInit() {
    this.paramMapSubscription = this.route.parent.params.subscribe( parentParams => {
      this.guildId = parentParams.serverId;
    });

    this.guildService.guildData$.subscribe(result => {
      if (result) {
        if (!this.guildId) {
          const infoForCurrentGuild = result.get(this.route.snapshot.parent.params.serverId);
          this.textChannels = infoForCurrentGuild.textChannels;
          this.messagesForCurrentChannel = infoForCurrentGuild.messagesForCurrentChannel;
          this.sortChannelsByPosition();
        }
        else {
          const infoForCurrentGuild = result.get(this.guildId);
          this.textChannels = infoForCurrentGuild.textChannels;
          this.messagesForCurrentChannel = infoForCurrentGuild.messagesForCurrentChannel;
          this.sortChannelsByPosition();
        }
      }
    });
    this.sortChannelsByPosition();
  }

  ngOnDestroy() {
    this.paramMapSubscription.unsubscribe();
  }

  onChannelClicked(position: number) {
    console.debug(`Channel clicked with position: ${position}`);
    this.textChannels.find(s => s.selected === true).selected = false;
    const selectedChannel = this.textChannels.find(s => s.position === position);
    selectedChannel.selected = true;
    this.router.navigate(['navbar', 'server', this.guildId, 'channel', selectedChannel.id]);
    console.debug(`Value of textChannels objects: ${JSON.stringify(this.textChannels)}`);
  }

  sortChannelsByPosition() {
    this.textChannels.sort((a, b) => a.position - b.position);
  }

  channelHeaderClicked() {
    this.channelHeaderMenuOpen = !this.channelHeaderMenuOpen;
  }

}
