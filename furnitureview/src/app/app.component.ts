import {Component, OnInit} from '@angular/core';
import {HttpClient} from '@angular/common/http';


@Component({
    selector: 'my-app',
    template: '<h1>{{orders[1].name}}</h1>'

})
export class AppComponent implements OnInit{

     orders: string;
  /*  orders = [
        {
            "id": "5bbcb04bde0f5a4098b32ec9",
            "name": "Камод2",
            "author": {
                "id": "null",
                "firstName": "Anton",
                "lastName": "Azarenko"
            },
            "orderTypeChoise": "CHEST_OF_DRAWERS",
            "moduleList": "null",
            "detailList": "null",
            "furnitureList": "null",
            "facadeList": "null"
        }
    ];*/
    constructor(private http: HttpClient) {

    }


    ngOnInit(){

        //this.http.get('http://localhost:8080/order/all').toPromise().then(o => o.json()).then(o => this.orders = o);

     this.http.get('http://localhost:8080/order/all').subscribe(data => { JSON.stringify(data)});
    }

}