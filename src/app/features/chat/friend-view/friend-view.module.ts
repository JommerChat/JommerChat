import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { FriendViewPageRoutingModule } from './friend-view-routing.module';

import { FriendViewPage } from './friend-view.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    FriendViewPageRoutingModule
  ],
  declarations: [FriendViewPage]
})
export class FriendViewPageModule {}
