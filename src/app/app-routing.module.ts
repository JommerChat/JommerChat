import { NgModule } from '@angular/core';
import { PreloadAllModules, RouterModule, Routes } from '@angular/router';
import {OktaAuthGuard, OktaCallbackComponent} from '@okta/okta-angular';

const routes: Routes = [
  {
    path: 'login/callback',
    component: OktaCallbackComponent
  },
  {
    path: 'login',
    loadChildren: () => import('./features/login/login.module').then(m => m.HomePageModule)
  },
  {
    path: '',
    redirectTo: 'login',
    pathMatch: 'full'
  },
  {
    path: 'navbar',
    loadChildren: () => import('./features/navbar/navbar.module').then( m => m.NavbarPageModule),
    canActivate: [ OktaAuthGuard ]
  },
  {
    path: 'mentions',
    loadChildren: () => import('./features/mentions/mentions.module').then( m => m.MentionsPageModule),
    canActivate: [ OktaAuthGuard ]
  },
  {
    path: 'explore',
    loadChildren: () => import('./features/explore/explore.module').then( m => m.ExplorePageModule),
    canActivate: [ OktaAuthGuard ]
  },
  {
    path: 'servers',
    loadChildren: () => import('./features/servers/servers.module').then( m => m.ServersPageModule),
    canActivate: [ OktaAuthGuard ]
  },


];

@NgModule({
  imports: [
    RouterModule.forRoot(routes, { preloadingStrategy: PreloadAllModules })
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
