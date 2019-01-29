export class OrderEx {
  id: number;
  name: string;
  address: string;
  customersName: string;
  telNumber: string;
  dateOfContract: string;
  dateOfCreate: string;
  userName: string;


  constructor(id: number, name: string, address: string, customersName: string, telNumber: string,
              dateOfContract: string, dateOfCreate: string, userName: string) {
    this.id = id;
    this.name = name;
    this.address = address;
    this.customersName = customersName;
    this.telNumber = telNumber;
    this.dateOfContract = dateOfContract;
    this.dateOfCreate = dateOfCreate;
    this.userName = userName;
  }
}
