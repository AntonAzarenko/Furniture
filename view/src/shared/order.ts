class Order {
  name: string;
  orderType: string;
  author:{
    id: string
    firstName: string
    lastName: string
  };
  detailList: string[];
  furnitureList: string[];
  facadeList: string[];
  moduleList: string[];
}
