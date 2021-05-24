import { NgModule } from '@angular/core';
import { PreloadAllModules, RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {
    path: 'login',
    loadChildren: () => import('./features/login/login.module').then(m => m.HomePageModule)
  },
  {
    path: '',
    redirectTo: 'navbar/chat',
    pathMatch: 'full'
  },
  {
    path: 'navbar',
    loadChildren: () => import('./features/navbar/navbar.module').then( m => m.NavbarPageModule)
  },  {
    path: 'mentions',
    loadChildren: () => import('./features/mentions/mentions.module').then( m => m.MentionsPageModule)
  },
  {
    path: 'explore',
    loadChildren: () => import('./features/explore/explore.module').then( m => m.ExplorePageModule)
  },
  {
    path: 'servers',
    loadChildren: () => import('./features/servers/servers.module').then( m => m.ServersPageModule)
  },


];

@NgModule({
  imports: [
    RouterModule.forRoot(routes, { preloadingStrategy: PreloadAllModules })
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
