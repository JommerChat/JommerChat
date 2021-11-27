import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { GuildPageRoutingModule } from './guild-routing.module';

import { GuildPage } from './guild.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    GuildPageRoutingModule
  ],
  declarations: [GuildPage]
})
export class GuildPageModule {}
