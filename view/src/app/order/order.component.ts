import { Component, OnInit } from '@angular/core';
import {OrderService} from "../order.service";

@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.css']
})
export class OrderComponent implements OnInit {
  orders: Object;
  constructor( private servise: OrderService) { }

  ngOnInit() {
   this.servise.getAllOrders();
  }

}
