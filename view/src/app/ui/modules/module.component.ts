import {Component, Inject, OnInit} from '@angular/core';
import {ModuleService} from "../../services/module.service";
import {MAT_DIALOG_DATA, MatDialog, MatDialogRef, MatSnackBar} from "@angular/material";
import {ActivatedRoute} from "@angular/router";
import {animate, state, style, transition, trigger} from "@angular/animations";
import {MenuComponent} from "../menu/menu.component";
import {FurnitureModule} from "../../entity/FurnitureModule";

export interface DialogCreateData {
  id: number;
  type: string;
  name: string;
  order_id: number;
}

export interface DialogDeleteData {
  modules: FurnitureModule[];
  module: FurnitureModule;
  moduleId: number;
}

@Component({
  selector: 'app-module',
  templateUrl: './module.component.html',
  styleUrls: ['./module.component.css'],
  animations: [
    trigger('detailExpand', [
      state('collapsed', style({height: '0px', minHeight: '0', display: 'none'})),
      state('expanded', style({height: '*'})),
      transition('expanded <=> collapsed', animate('225ms cubic-bezier(0.4, 0.0, 0.2, 1)')),
    ]),
  ],
})
export class ModuleComponent implements OnInit {
  public modules: FurnitureModule[];
  public moduleF: FurnitureModule;
  private id: number;
  private type: string;
  private name: string;
  private order_id: number;
  private moduleId: number;
  dataSource: Object[];


  displayedColumns: string [] = ['name', 'moduleType'];


  constructor(public service: ModuleService,
              public dialog: MatDialog,
              public dialogD: MatDialog,
              public snackBar: MatSnackBar,
              public route: ActivatedRoute,
              public menu: MenuComponent) {
  }

  ngOnInit() {
    this.menu.ngOnInit();
    this.getAllModules();
  }

  getAllModules() {
    const id = +this.route.snapshot.paramMap.get('id');
    this.order_id = id;
    this.service.getAll(id).subscribe(
      (data: any[]) => {
        this.modules = (data);
        this.dataSource = (data)
      }
    )
  }

  openDialogCreate(event) {
    const dialogRef = this.dialog.open(OpenDialogToCreateModuleComponent, {
      width: '600px',
      data: {}
    });
    dialogRef.afterClosed().subscribe(result => {
      this.type = result.type;
      this.name = result.name;
      if (this.name == null) {
        this.snackBar.open('Модуль не может быть создан без имени', 'ERROR', {
          duration: 2000,
        });
      } else if (this.type == null) {
        this.snackBar.open('Модуль не может быть создан без типа', 'ERROR', {
          duration: 2000,
        });
      }
      this.moduleF = new FurnitureModule(this.id, this.name, this.type, this.order_id);
      this.save(this.moduleF);
    });
  }

  openDialogDelete(event) {
    const dialogRefD = this.dialogD.open(OpenDialogToDeleteModuleComponent, {
      data: {modules: this.modules, moduleId: this.moduleId}
    });
    dialogRefD.afterClosed().subscribe(result => {
      this.moduleId = result.moduleId;
      this.delete(this.moduleId)
    })
  }

  save(data) {
    this.service.save(data).subscribe(data => this.modules.push(data));
    //window.location.reload();
  }

  delete(id: number) {
    this.service.delete(id);
    let moduleId = id;
    this.modules.forEach(function (value, index, array) {
      if (value.id == id) {
        moduleId = index;
      }
    });
    this.modules.splice(moduleId, 1);
    window.location.reload();
  }
}

@Component({
  selector: 'app-dialog',
  templateUrl: './dialog.html'
})
export class OpenDialogToCreateModuleComponent {
  constructor(public dialogRef: MatDialogRef<OpenDialogToCreateModuleComponent>,
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
  constructor(public dialogRef: MatDialogRef<OpenDialogToDeleteModuleComponent>,
              @Inject(MAT_DIALOG_DATA) public data: DialogDeleteData) {
  }

  onNoClick(): void {
    this.dialogRef.close();
  }
}



