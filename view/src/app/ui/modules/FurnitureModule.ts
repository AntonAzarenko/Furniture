import {Component} from "@angular/core";

@Component({
  selector: 'app-furnitureModule',
  templateUrl: './dialog.html'
})
export class FurnitureModule {
  id: number;
  name: string;
  moduleType: string;
  order_id: number;

  constructor(id: number,
              name: string,
              moduleType: string,
              order_id: number) {
    this.id = id;
    this.name = name;
    this.moduleType = moduleType;
    this.order_id = order_id
  }
}
