import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {
    path: 'login',
    loadComponent: () => import('./components/login/login.component').then( m => m.LoginComponent),
  },
  {
    path: '',
    loadComponent: () => import('./components/dashboard/dashboard.component').then( m => m.DashboardComponent),
  },
  {
    path: 'register',
    loadComponent: () => import('./components/register/register.component').then( m => m.RegisterComponent),
  },
  {
    path: 'report',
    loadComponent: () => import('./components/report/report.component').then( m => m.ReportComponent),
  },
  {
    path: '**',
    redirectTo: 'login',
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
