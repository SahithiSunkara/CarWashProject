import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {AppRoutingModule} from './app-routing.module'
import { AppComponent } from './app.component';
import { CustomerRegisterComponent } from './customer/customer-register/customer-register.component'
import { CustomerModulModule } from './customer/customer-modul/customer-modul.module';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HomeLoginComponent } from './customer/home-login/home-login.component';
import { CustomerHomeComponent } from './customer/customer-home/customer-home.component';
import { WasherHomeComponent } from './customer/washer-home/washer-home.component';
import { AdminHomeComponent } from './customer/admin-home/admin-home.component';
import {MatTableModule } from '@angular/material/table';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatSortModule } from '@angular/material/sort';
import { NewOrderComponent } from './customer/new-order/new-order.component';
import {MatDialogModule} from '@angular/material/dialog';
import { OrdersListComponent } from './customer/orders-list/orders-list.component'

@NgModule({
declarations: [
AppComponent,
CustomerRegisterComponent,
HomeLoginComponent,
CustomerHomeComponent,
WasherHomeComponent,
AdminHomeComponent,
NewOrderComponent,
OrdersListComponent
],
imports: [
BrowserModule,
AppRoutingModule,
CustomerModulModule,
BrowserAnimationsModule,
MatTableModule,
MatPaginatorModule,
MatSortModule,
MatDialogModule

],
exports:[
	MatTableModule,
MatPaginatorModule,
MatSortModule,
MatDialogModule
],
providers: [],
bootstrap: [AppComponent]
})
export class AppModule { }