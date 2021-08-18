import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FiledashboardComponent } from './filedashboard/filedashboard.component';
import { AdduserComponent } from './adduser/adduser.component';
import { RouterModule, Routes } from '@angular/router';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { NgxPaginationModule } from 'ngx-pagination';


const fileinitialiserouting: Routes = [
  {path: 'filedash', component: FiledashboardComponent},
  {path: 'adduesr', component: AdduserComponent}
];

@NgModule({
  declarations: [FiledashboardComponent, AdduserComponent],
  imports: [
    CommonModule,ReactiveFormsModule,FormsModule, RouterModule.forChild(fileinitialiserouting),
    NgxPaginationModule
  ]
})
export class FileinitiliserModule { }
