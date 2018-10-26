import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import Order = jasmine.Order;
import {OrderComponent} from "./order/order.component";

const routes: Routes = [
  {
    path: '', children: []
  },
  {
    path: 'orders', component: OrderComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
  providers: []
})
export class AppRoutingModule { }
