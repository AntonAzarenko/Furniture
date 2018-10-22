var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
var AppComponent = /** @class */ (function () {
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
    function AppComponent(http) {
        this.http = http;
    }
    AppComponent.prototype.ngOnInit = function () {
        //this.http.get('http://localhost:8080/order/all').toPromise().then(o => o.json()).then(o => this.orders = o);
        this.http.get('http://localhost:8080/order/all').subscribe(function (data) { JSON.stringify(data); });
    };
    AppComponent = __decorate([
        Component({
            selector: 'my-app',
            template: '<h1>{{orders[1].name}}</h1>'
        }),
        __metadata("design:paramtypes", [HttpClient])
    ], AppComponent);
    return AppComponent;
}());
export { AppComponent };
//# sourceMappingURL=app.component.js.map