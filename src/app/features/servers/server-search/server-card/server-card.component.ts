import {Component, Input, OnInit} from '@angular/core';
import {ServerCardDetails} from '../../../../shared/models/ServerCardDetails';
import {Router} from '@angular/router';

@Component({
  selector: 'app-server-card',
  templateUrl: './server-card.component.html',
  styleUrls: ['./server-card.component.scss'],
})
export class ServerCardComponent implements OnInit {

  @Input('cardDetails')
  serverCardDetails: ServerCardDetails;

  constructor(private router: Router) { }

  ngOnInit() {}

  navigateToGuild(guildId) {
    this.router.navigateByUrl('/navbar/servers/guild/:guildId', guildId);
  }

}
