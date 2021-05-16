import { NgModule } from '@angular/core';
import { PreloadAllModules, RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {
    path: 'login',
    loadChildren: () => import('./features/login/login.module').then(m => m.HomePageModule)
  },
  {
    path: '',
    redirectTo: 'navbar',
    pathMatch: 'full'
  },
  {
    path: 'navbar',
    loadChildren: () => import('./features/navbar/navbar.module').then( m => m.NavbarPageModule)
  },
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes, { preloadingStrategy: PreloadAllModules })
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
