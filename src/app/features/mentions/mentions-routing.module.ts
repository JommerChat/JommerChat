import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { MentionsPage } from './mentions.page';

const routes: Routes = [
  {
    path: '',
    component: MentionsPage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class MentionsPageRoutingModule {}
