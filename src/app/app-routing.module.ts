import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CustomerRegisterComponent } from './customer/customer-register/customer-register.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HomeLoginComponent } from './customer/home-login/home-login.component';
import { CustomerHomeComponent } from './customer/customer-home/customer-home.component';
import { WasherHomeComponent } from './customer/washer-home/washer-home.component';
import { AdminHomeComponent } from './customer/admin-home/admin-home.component';
import { NewOrderComponent } from './customer/new-order/new-order.component';
import { OrdersListComponent} from './customer/orders-list/orders-list.component';

const routes: Routes = [
{path: '', component: HomeLoginComponent},
{path: 'register', component: CustomerRegisterComponent},
{path: 'customerhome', component: CustomerHomeComponent},
{path: 'washerhome', component: WasherHomeComponent},
{path: 'adminhome', component: AdminHomeComponent},
{path: 'neworder', component: NewOrderComponent},
{path: 'editorder/:id', component: NewOrderComponent},
{path: 'edituser/:id', component: CustomerRegisterComponent},
{path: 'orderlist', component: OrdersListComponent}

];

@NgModule({
  imports: [
	RouterModule.forRoot(routes),
	FormsModule,
    ReactiveFormsModule
],
  exports: [RouterModule]
})
export class AppRoutingModule { }
