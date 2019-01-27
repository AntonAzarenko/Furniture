import {Component, OnInit, ViewChild} from '@angular/core';
import {OrderService} from "../../services/order.service";
import {MatDialog, MatPaginator, MatSort} from "@angular/material";
import {ActivatedRoute} from "@angular/router";
import {animate, state, style, transition, trigger} from "@angular/animations";
import {OpenDialogCreateOrderComponentComponent} from "./open-dialog-create-order-component/open-dialog-create-order-component.component";
import {TokenStorageService} from "../../auth/token-storage.service";


@Component({
  selector: 'app-orders',
  templateUrl: './orders.component.html',
  styleUrls: ['./orders.component.css'],
  animations: [
    trigger('detailExpand', [
      state('collapsed', style({height: '0px', minHeight: '0', display: 'none'})),
      state('expanded', style({height: '*'})),
      transition('expanded <=> collapsed', animate('225ms cubic-bezier(0.4, 0.0, 0.2, 1)')),
    ]),
  ],
})
export class OrdersComponent implements OnInit {
  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;
  dataSource: OrderEx[];
  userName: string;
  orderEx: OrderEx;

  private id: number;
  private name: string;
  private customersName: string;
  private telNumber: string;
  private address: string;

  displayedColumns: string [] = ['name', 'address', 'telNumber', 'customersName', 'dateOfCreate', 'dateOfContract'];


  constructor(private service: OrderService, private route: ActivatedRoute,
              public dialog: MatDialog,
              private tokenStorage: TokenStorageService) {
  }

  ngOnInit() {
    this.userName = this.tokenStorage.getUsername();
    this.getAllOrders(this.userName);
  }

  getAllOrders(userName: string) {
    this.service.getAllByUserName(userName).subscribe(
      (data: any[]) => {
        this.dataSource = (data);
      });
    console.log(this.dataSource);
  }

  openDialogCreateOrder(event) {
    const dialogRef = this.dialog.open(OpenDialogCreateOrderComponentComponent, {
      width: '600px',
      data: {}
    });
    dialogRef.afterClosed().subscribe(result => {
      this.id = result.id;
      this.name = result.name;
      this.customersName = result.customersName;
      this.address = result.address;
      this.telNumber = result.telNumber;
      this.orderEx = this.createOrder();
      this.save(this.orderEx);
    });
  }

  createOrder() {
    return new OrderEx(this.id, this.name, this.address, this.customersName, this.telNumber,
      null, null, this.userName);
  }

  save(data) {
    this.service.save(data).subscribe(data => this.dataSource.push(data));
  }
}


@Component({
  selector: 'order',
  template: ''
})
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
