import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { ServersPageRoutingModule } from './servers-routing.module';

import { ServersPage } from './servers.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    ServersPageRoutingModule
  ],
  declarations: [ServersPage]
})
export class ServersPageModule {}
