
import { Routes } from '@angular/router';

import { AdminLayoutComponent } from './layouts/admin-layout/admin-layout.component';
import { LoginComponent } from './login/login.component';
import { FileinitiliserModule } from './module/fileinitiliser/fileinitiliser.module';
import { SianctionletterModule } from './module/sianctionletter/sianctionletter.module';

export const AppRoutes: Routes = [
  {
    path: '',
    component: LoginComponent
  }, {
    path: 'role',
    component: AdminLayoutComponent,
    children: [
      {path: 'fileinitiliase', loadChildren: () => FileinitiliserModule},
      {path: 'sianctionletter', loadChildren: () => SianctionletterModule}

    ]
  },
  {
    path: '**',
    redirectTo: 'dashboard'
  }
];



