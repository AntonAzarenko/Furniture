import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {OrderEx} from "../entity/OrderEx";




@Injectable({
  providedIn: 'root'
})
export class OrderService {

  constructor(private http: HttpClient) {
  }

  getAllByUserName(name: string) {
    return this.http.get('https://back-end-furniture.herokuapp.com/'+ name);
  }

  get(id: number) {
    return this.http.get('https://back-end-furniture.herokuapp.com/' + id);
  }

  save(order: OrderEx){
    console.log(order);
    return this.http.post<OrderEx>('https://back-end-furniture.herokuapp.com/',  order);
  }
}
