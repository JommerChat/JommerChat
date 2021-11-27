import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { GuildPageRoutingModule } from './guild-routing.module';

import { GuildPage } from './guild.page';
import {ChannelsComponent} from './channels/channels.component';
import {MessagesComponent} from './messages/messages.component';
import {MembersComponent} from './members/members.component';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    GuildPageRoutingModule
  ],
  declarations: [GuildPage, ChannelsComponent, MessagesComponent, MembersComponent]
})
export class GuildPageModule {}
