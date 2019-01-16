import { Component, OnInit } from '@angular/core';
import {OrderService} from "../../services/order.service";

@Component({
  selector: 'app-orders',
  templateUrl: './orders.component.html',
  styleUrls: ['./orders.component.css']
})
export class OrdersComponent implements OnInit {

  private orders: Object[];

  constructor(private service: OrderService) { }

  ngOnInit() {
    this.getAllOrders();
  }

  getAllOrders(){
    this.service.getAll().subscribe((data:any[])=>{
      this.orders = (data);
    });
  }

  createOrder(){

  }
}
