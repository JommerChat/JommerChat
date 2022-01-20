import {Component, OnDestroy, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {Subscription} from 'rxjs';
import {GuildService} from './guild.service';

@Component({
  selector: 'app-guild',
  templateUrl: './guild.page.html',
  styleUrls: ['./guild.page.scss'],
})
export class GuildPage implements OnInit, OnDestroy {

  guildId: string;

  paramMapSubscription: Subscription;


  constructor(private router: Router, private route: ActivatedRoute, private guildService: GuildService) { }

  ngOnInit() {
    this.paramMapSubscription = this.route.paramMap.subscribe( paramMap => {
      this.guildId = paramMap.get('serverId');
      this.guildService.manageGuildInfo(this.guildId);
    });
    this.guildService.guildData$.subscribe(result => {
      if (result?.has(this.guildId)) {
        const selectedId = result.get(this.guildId).textChannels.find(s => s.selected).id;
        this.router.navigate(['channel', selectedId], {relativeTo: this.route});
      }
    });
  }

  ngOnDestroy() {
    this.paramMapSubscription.unsubscribe();
  }

}
