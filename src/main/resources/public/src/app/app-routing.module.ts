import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { HomeComponent } from './home/home.component';
import { IndexComponent } from './index/index.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { RegFormComponent } from './reg-form/reg-form.component';
import { RegModalFormComponent} from './reg-modal-form/reg-modal-form.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { PagenotfoundComponent } from './pagenotfound/pagenotfound.component';
import { RegisterFinalComponent } from './register-final/register-final.component';
import { AuthGuard } from './_guards/auth.guard';

const routes: Routes = [
  {path: '', redirectTo: 'index', pathMatch: 'full'},
  {path: 'login', component: LoginComponent},
  {path: 'register', component: RegisterComponent},
  {path: 'reg-form' , component: RegFormComponent},
  {path: 'register-final', component: RegisterFinalComponent},
  {path: 'reg-modal-form' , component: RegModalFormComponent},
  {path: 'index', component: IndexComponent},
  {path: 'dashboard', component: DashboardComponent},
  {path: 'home', component: HomeComponent, canActivate: [AuthGuard]},
  {path: '**', component: PagenotfoundComponent}

];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
