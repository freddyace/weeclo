import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { IndexComponent } from './index/index.component';
import { HomeComponent } from './home/home.component';
import { FooterComponent } from './footer/footer.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';


import { UserExampleService } from './_services/userexample.service';
import { IndexheaderComponent } from './indexheader/indexheader.component';
import { HomeheaderComponent } from './homeheader/homeheader.component';

import { AuthGuard } from './_guards/auth.guard';
import { RegFormComponent } from './reg-form/reg-form.component';
import { RegModalFormComponent } from './reg-modal-form/reg-modal-form.component';
import { PagenotfoundComponent } from './pagenotfound/pagenotfound.component';

//example stuff
import { HeaderComponent } from './header/header.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { DashFavoritesComponent } from './dash-favorites/dash-favorites.component';
import { DashTrendingComponent } from './dash-trending/dash-trending.component';
import { DashRecommendedComponent } from './dash-recommended/dash-recommended.component';
import { MessagesComponent } from './messages/messages.component';
import { SearchComponent } from './search/search.component';
import { DashInventoryComponent } from './dash-inventory/dash-inventory.component';
import { ContactComponent } from './contact/contact.component';
import { RegisterFinalComponent } from './register-final/register-final.component';

@NgModule({
  declarations: [
    AppComponent,
    IndexComponent,
    HomeComponent,
    FooterComponent,
    LoginComponent,
    RegisterComponent,
    IndexheaderComponent,
    HomeheaderComponent,
    RegFormComponent,
    RegModalFormComponent,
    PagenotfoundComponent,
    
    HeaderComponent,
    DashboardComponent,
    DashFavoritesComponent,
    DashTrendingComponent,
    DashRecommendedComponent,
    MessagesComponent,
    SearchComponent,
    DashInventoryComponent,
    ContactComponent,
    RegisterFinalComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule, ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [UserExampleService, AuthGuard],
  bootstrap: [AppComponent]
})
export class AppModule { }
