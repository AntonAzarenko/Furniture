import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {OrderEx} from "../ui/orders/orders.component";



@Injectable({
  providedIn: 'root'
})
export class OrderService {

  constructor(private http: HttpClient) {
  }

  getAllByUserName(name: string) {
    return this.http.get('http://localhost:8080/furniture/order/'+ name);
  }

  get(id: number) {
    return this.http.get('http://localhost:8080/furniture/order/' + id);
  }

  save(order: OrderEx){
    console.log(order);
    return this.http.post<OrderEx>('http://localhost:8080/furniture/order',  order);
  }
}
