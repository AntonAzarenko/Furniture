import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material";
import {DialogCreateData} from "../orders.component";

@Component({
  selector: 'app-open-dialog-create-order-component',
  templateUrl: './open-dialog-create-order-component.component.html',
  styleUrls: ['./open-dialog-create-order-component.component.css']
})
export class OpenDialogCreateOrderComponentComponent implements OnInit {

  name:string;
  customersName:string;
  telNumber:string;
  address:string;

  constructor(public dialogRef: MatDialogRef<OpenDialogCreateOrderComponentComponent>,
              @Inject(MAT_DIALOG_DATA) public data: DialogCreateData) {
  }

  ngOnInit() {
  }

  onNoClick(): void {
    this.dialogRef.close();
  }
}
