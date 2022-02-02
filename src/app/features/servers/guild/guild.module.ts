import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { GuildPageRoutingModule } from './guild-routing.module';

import { GuildPage } from './guild.page';
import {ChannelsComponent} from './channels/channels.component';
import {MessagesComponent} from './messages/messages.component';
import {MembersComponent} from './members/members.component';
import {AuthInterceptorService} from '../../../shared/auth/auth-interceptor.service';

@NgModule({
    imports: [
        CommonModule,
        FormsModule,
        IonicModule,
        GuildPageRoutingModule,
        ReactiveFormsModule
    ],
  declarations: [GuildPage, ChannelsComponent, MessagesComponent, MembersComponent]
})
export class GuildPageModule {}
