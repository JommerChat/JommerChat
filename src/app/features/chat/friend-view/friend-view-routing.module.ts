import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { FriendViewPage } from './friend-view.page';

const routes: Routes = [
  {
    path: '',
    component: FriendViewPage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class FriendViewPageRoutingModule {}
