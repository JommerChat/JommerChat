import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouteReuseStrategy } from '@angular/router';

import { IonicModule, IonicRouteStrategy } from '@ionic/angular';

import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';
import {HttpClientModule} from '@angular/common/http';
import {
  OKTA_CONFIG,
  OktaAuthModule
} from '@okta/okta-angular';
import {environment} from '../environments/environment';

const config = {
  issuer: environment.issuer,
  clientId: environment.clientId,
  redirectUri: environment.redirectUri,
  scopes: environment.scopes.split(/\s+/)
};

@NgModule({
  declarations: [AppComponent],
  entryComponents: [],
  imports: [BrowserModule, IonicModule.forRoot(), AppRoutingModule, HttpClientModule, OktaAuthModule],
  providers: [{ provide: RouteReuseStrategy, useClass: IonicRouteStrategy }, {provide: OKTA_CONFIG, useValue: config}],
  bootstrap: [AppComponent],
})
export class AppModule {}
