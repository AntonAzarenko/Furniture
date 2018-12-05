import {Component, Inject, OnInit} from '@angular/core';
import {ModuleService} from "../../services/module.service";
import {ErrorStateMatcher, MAT_DIALOG_DATA, MatDialog, MatDialogRef, MatSnackBar} from "@angular/material";
import {ActivatedRoute} from "@angular/router";
import {HeaderComponent} from "../header/header.component";

export interface DialogCreateData {
  id: number;
  type: string;
  name: string;
  order_id: number;

}

export interface DialogDeleteData {
  modules: Object[];
  module: FurnitureModule;
}

@Component({
  selector: 'app-module',
  templateUrl: './module.component.html',
  styleUrls: ['./module.component.css']
})
export class ModuleComponent implements OnInit {
  private modules: Object[];
  private moduleF: FurnitureModule;
  private id: string;
  private type: string;
  private name: string;
  private order_id: number;

  constructor(private service: ModuleService,
              public dialog: MatDialog,
              public dialogD: MatDialog,
              public snackBar: MatSnackBar,
              private route: ActivatedRoute,
             ) {
  }

  ngOnInit() {
    this.getAllModules();
  }

  getAllModules() {
    const id = +this.route.snapshot.paramMap.get('id');
    this.order_id = id;
    this.service.getAll(id).subscribe(
      (data: any[]) => {
        this.modules = (data)
      }
    )
  }

  openDialogCreate(event) {
    const dialogRef = this.dialog.open(OpenDilogToCreateModuleComponent, {
      width: '600px',
      data: {}
    });
    dialogRef.afterClosed().subscribe(result => {
      this.type = result.type;
      this.name = result.name;
      console.log(this.type);
      console.log(this.name);
      if (this.name == null) {
        this.snackBar.open('Модуль не может быть создан без имени', 'ERROR', {
          duration: 2000,
        });
      } else if (this.type == null) {
        this.snackBar.open('Модуль не может быть создан без типа', 'ERROR', {
          duration: 2000,
        });
      }
      this.moduleF = new FurnitureModule(this.id, this.name, this.type,this.order_id);
      console.log(this.moduleF);
      this.save(this.moduleF);
    });
  }

  openDialogDelete(event){
    const dialogRefD = this.dialogD.open(OpenDialogToDeleteModuleComponent, {
      data: { modules: this.modules}
    });
    dialogRefD.afterClosed().subscribe(result =>{
      this.moduleF = result.module;
      console.log(this.moduleF);
    })
  }



  save(data) {
    this.service.save(data).subscribe(data => this.modules.push(data));
  }

  deleteModule(event){
    const id = +this.route.snapshot.paramMap.get('id');
    console.log(id);
    this.service.delete(id);
    window.location.reload();
  }
}

@Component({
  selector: 'app-dialog',
  templateUrl: './dialog.html'
})
export class OpenDilogToCreateModuleComponent {
  constructor(public dialogRef: MatDialogRef<OpenDilogToCreateModuleComponent>,
              @Inject(MAT_DIALOG_DATA) public data: DialogCreateData) {
  }

  onNoClick(): void {

    this.dialogRef.close();
  }
}

@Component({
  selector: 'app-dialog-delete',
  templateUrl: './dialog.delete.html'
})
export class OpenDialogToDeleteModuleComponent {
  constructor(public dialogRef: MatDialogRef<OpenDilogToCreateModuleComponent>,
              @Inject(MAT_DIALOG_DATA) public data: DialogDeleteData) {
  }

  onNoClick(): void {

    this.dialogRef.close();
  }
}

@Component({
  selector: 'app-furnitureModule',
  templateUrl: './dialog.html'
})
export class FurnitureModule {
  id: string;
  name: string;
  moduleType: string;
  order_id:number;
  detailList: string;

  constructor(id: string,
              name: string,
              moduleType: string,
              order_id: number) {
    this.id = id;
    this.name = name;
    this.moduleType = moduleType;
    this.order_id = order_id
  }
}

