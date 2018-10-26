import { Injectable } from '@angular/core';
import {Http} from "@angular/http";




@Injectable()
export class OrderService {
  constructor(private http: Http) { }

  getAllOrders(){
     this.http.get('http://localhost:8080/order/all').subscribe(data => {return data});
  }

}
