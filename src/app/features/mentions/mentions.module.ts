import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { MentionsPageRoutingModule } from './mentions-routing.module';

import { MentionsPage } from './mentions.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    MentionsPageRoutingModule
  ],
  declarations: [MentionsPage]
})
export class MentionsPageModule {}
