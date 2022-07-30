import { NgModule } from '@angular/core';
import { PreloadAllModules, RouterModule, Routes } from '@angular/router';
import {AuthGuardService} from './shared/auth/auth-guard.service';

const routes: Routes = [
  {
    path: 'login',
    loadChildren: () => import('./features/login/login/login.module').then(m => m.HomePageModule)
  },
  {
    path: 'signup',
    loadChildren: () => import('./features/login/create-account/create-account.module').then(m => m.CreateAccountPageModule)
  },
  {
    path: '',
    redirectTo: 'login',
    pathMatch: 'full'
  },
  {
    path: 'navbar',
    loadChildren: () => import('./features/navbar/navbar.module').then( m => m.NavbarPageModule),
    // canActivate: [ AuthGuardService ]
  },
  {
    path: 'mentions',
    loadChildren: () => import('./features/mentions/mentions.module').then( m => m.MentionsPageModule),
    // canActivate: [ AuthGuardService ]
  },
  {
    path: 'explore',
    loadChildren: () => import('./features/explore/explore.module').then( m => m.ExplorePageModule),
    // canActivate: [ AuthGuardService ]
  },
  {
    path: 'servers',
    loadChildren: () => import('./features/servers/servers.module').then( m => m.ServersPageModule),
    // canActivate: [ AuthGuardService ]
  },
  {
    path: 'create-account',
    loadChildren: () => import('./features/login/create-account/create-account.module').then( m => m.CreateAccountPageModule)
  }




];

@NgModule({
  imports: [
    RouterModule.forRoot(routes, { preloadingStrategy: PreloadAllModules })
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
