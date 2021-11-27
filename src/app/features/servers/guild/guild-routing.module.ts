import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { GuildPage } from './guild.page';

const routes: Routes = [
  {
    path: '',
    component: GuildPage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class GuildPageRoutingModule {}
