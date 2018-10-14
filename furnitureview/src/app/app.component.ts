import {Component} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from "rxjs/internal/Observable";


@Component({
    selector: 'my-app',
    template: `<label>Order</label>
    <ol>
    <li *ngFor="let order of orders">{{order.id}}</li>
    </ol>`

})
export class AppComponent {

    orders = this.http.get('http://localhost:8080/order/all');

    constructor(private http: HttpClient) {
    }

    getMeApp(): Observable<AppComponent[]> {
        return this.http.get<AppComponent[]>('http://localhost:8080/order/all');
    }

}