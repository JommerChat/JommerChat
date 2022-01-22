import { Component, OnInit } from '@angular/core';
import {GuildService} from '../guild.service';
import {ActivatedRoute} from '@angular/router';
import {Subscription} from 'rxjs';
import {Member} from '../../../../shared/models/Member';

@Component({
  selector: 'app-members',
  templateUrl: './members.component.html',
  styleUrls: ['./members.component.scss'],
})
export class MembersComponent implements OnInit {

  members: Array<Member> = [];

  guildId: string;

  paramMapSubscription: Subscription;

  constructor(private guildService: GuildService, private route: ActivatedRoute) {}

  ngOnInit() {
    this.paramMapSubscription = this.route.parent.params.subscribe(parentParams => {
      this.guildId = parentParams.serverId;
    });

    this.guildService.guildData$.subscribe(result => {
      if (result) {
        if (!this.guildId) {
          this.members = result.get(this.route.snapshot.parent.params.serverId).members;
        } else {
          this.members = result.get(this.guildId).members;
        }
        this.members.sort((a, b) => a.username.localeCompare(b.username));
      }
    });
  }

}
