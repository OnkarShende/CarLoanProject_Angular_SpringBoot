import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SianctionDashboardComponent } from './sianction-dashboard/sianction-dashboard.component';
import { RouterModule, Routes } from '@angular/router';

const sianctionerouting: Routes = [
  {path: 'sianctiondash', component: SianctionDashboardComponent}
];

@NgModule({
  declarations: [SianctionDashboardComponent],
  imports: [
    CommonModule, RouterModule.forChild(sianctionerouting)
  ]
})
export class SianctionletterModule { }
