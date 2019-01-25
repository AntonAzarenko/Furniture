import {Component, OnInit, ViewChild} from '@angular/core';
import {OrderService} from "../../services/order.service";
import {MatDialog, MatPaginator, MatSort} from "@angular/material";
import {ActivatedRoute} from "@angular/router";
import {animate, state, style, transition, trigger} from "@angular/animations";
import {OpenDialogCreateOrderComponentComponent} from "./open-dialog-create-order-component/open-dialog-create-order-component.component";


export interface OrdersDataItem {
  id: string;
  name: string;
}

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

  displayedColumns: string [] = ['name', 'address', 'telNumber', 'customersName', 'dateOfCreate', 'dateOfContract'];


  constructor(private service: OrderService, private route: ActivatedRoute,
              public dialog: MatDialog) {
  }

  ngOnInit() {
    this.getAllOrders();
  }

  getAllOrders() {
    this.service.getAll().subscribe(
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

    });
  }

  save() {
    // this.service.save(data).subscribe(data => this.dataSource.push(data));
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


  constructor(id: number, name: string, address: string, customersName: string, telNumber: string, dateOfContract: string, dateOfCreate: string) {
    this.id = id;
    this.name = name;
    this.address = address;
    this.customersName = customersName;
    this.telNumber = telNumber;
    this.dateOfContract = dateOfContract;
    this.dateOfCreate = dateOfCreate;
  }
}
