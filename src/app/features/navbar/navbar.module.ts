import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { NavbarPageRoutingModule } from './navbar-routing.module';

import { NavbarPage } from './navbar.page';
import {CreateServerComponent} from '../servers/create-server/create-server.component';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    NavbarPageRoutingModule,
    ReactiveFormsModule
  ],
    declarations: [NavbarPage, CreateServerComponent]
})
export class NavbarPageModule {}
