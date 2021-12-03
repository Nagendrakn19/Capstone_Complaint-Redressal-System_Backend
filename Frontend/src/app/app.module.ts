import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { FooterComponent } from './components/footer/footer.component';
import { LoginComponent } from './components/login/login.component';
import { AboutComponent } from './components/about/about.component';
import { ContactComponent } from './components/contact/contact.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AdminModule } from './components/admin/admin.module';
import { AdminComponent } from './components/admin/admin.component';
import { HttpClientModule } from '@angular/common/http';
import { CustomerComponent } from './components/customer/customer.component';
import { ManagerComponent } from './components/manager/manager.component';
import { EngineerComponent } from './components/engineer/engineer.component';
import { ManagerNavbarComponent } from './components/manager/manager-navbar/manager-navbar.component';
import { EngineerNavbarComponent } from './components/engineer/engineer-navbar/engineer-navbar.component';
import { CustomerModule } from './components/customer/customer.module';
import { AssignEngineerComponent } from './components/manager/assign-engineer/assign-engineer.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    FooterComponent,
    LoginComponent,
    AboutComponent,
    ContactComponent,
    AdminComponent,
    CustomerComponent,
    ManagerComponent,
    EngineerComponent,
    ManagerNavbarComponent,
    EngineerNavbarComponent,
    AssignEngineerComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    AdminModule,
    HttpClientModule,
    CustomerModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
