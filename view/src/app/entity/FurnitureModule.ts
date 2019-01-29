
export class FurnitureModule {
  public id: number;
  public name: string;
  public moduleType: string;
  public order_id: number;

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
