import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { NavbarPage } from './navbar.page';
import {ChatPage} from '../chat/chat.page';

const routes: Routes = [
  {
    path: '',
    component: NavbarPage,
    children: [
      {path: 'chat',
        loadChildren: () => import('./../chat/chat.module').then( m => m.ChatPageModule)
      },
      {
        path: 'mentions',
        loadChildren: () => import('./../mentions/mentions.module').then(m => m.MentionsPageModule)
      },
      {
        path: 'explore',
        loadChildren: () => import('./../explore/explore.module').then(m => m.ExplorePageModule)
      },
      {
        path: 'servers',
        loadChildren: () => import('./../servers/servers.module').then(m => m.ServersPageModule)
      },
      {
        path: 'server/:serverId',
        loadChildren: () => import('./../servers/servers.module').then(m => m.ServersPageModule)
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class NavbarPageRoutingModule {}
