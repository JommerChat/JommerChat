import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { GuildPage } from './guild.page';
import {ChannelsComponent} from './channels/channels.component';

const routes: Routes = [
  {
    path: '',
    component: GuildPage,
    children: [
      {
        path: 'channel/:channelId',
        component: ChannelsComponent
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class GuildPageRoutingModule {}
