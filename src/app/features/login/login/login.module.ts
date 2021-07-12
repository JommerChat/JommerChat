import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { IonicModule } from '@ionic/angular';
import {FormGroup, FormsModule, ReactiveFormsModule} from '@angular/forms';
import { LoginPage } from './login.page';

import { HomePageRoutingModule } from './login-routing.module';


@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    HomePageRoutingModule,
    ReactiveFormsModule
  ],
  declarations: [LoginPage]
})
export class HomePageModule {}
