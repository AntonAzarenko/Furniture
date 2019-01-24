import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {OrderEx} from "../ui/orders/orders.component";



@Injectable({
  providedIn: 'root'
})
export class OrderService {

  constructor(private http: HttpClient) {
  }

  getAll() {
    return this.http.get('http://localhost:8080/order');
  }

  get(id: number) {
    return this.http.get('http://localhost:8080/order/' + id);
  }

  save(order: OrderEx){
    return this.http.post<OrderEx>('http://localhost:8080/order',  order);
  }
}
