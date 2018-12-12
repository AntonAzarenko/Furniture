import {Component, OnInit, ViewChild} from '@angular/core';
import {MatDialog, MatPaginator, MatSort, MatTableDataSource} from '@angular/material';
import {DetailService} from "../../services/detail.service";
import {ActivatedRoute} from "@angular/router";
import {SelectionModel} from "@angular/cdk/collections";
import {DetailCreateDialogComponent} from "./detail-create-dialog/detail-create-dialog.component";
import {ColorserviceService} from "../../services/colorservice.service";
import {EdgeMaterialServiceService} from "../../services/edge-material-service.service";


export interface DetailData {
  id: string;
  name: string;
  x: string;
  y: string;
  count: string;
  thickness: string;
  material: string;
}



@Component({
  selector: 'app-details',
  templateUrl: './details.component.html',
  styleUrls: ['./details.component.css'],
})
export class DetailsComponent implements OnInit {
  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;

  dataSource: Object[];
  selectedRows: Details[];
  creDetail: Details;

  detId: number[];
  id: number;
  colors: Object[];
  edgeMat: Object[];

  private name: string;
  private x: string;
  private y: string;
  private count: string;
  private thickness: string;
  private material: string;
  private edgeId: number;
  private colorId: number;

  selection = new SelectionModel<Details>(true, []);


  constructor(private service: DetailService,
              private colorService: ColorserviceService,
              private edgeService: EdgeMaterialServiceService,
              private route: ActivatedRoute,
              public dialog: MatDialog) {
  }

  displayedColumns: string[] = ['select', 'name', 'x', 'y', 'count', 'thickness', 'material'];

  ngOnInit() {
    this.getDetByModID();
    this.colorService.getAllColorMaterail().subscribe((data:any[]) =>{
      this.colors = (data)
    });
    this.edgeService.getAllEdge().subscribe(
      (data:any[]) =>{
        this.edgeMat = (data);
      }
    )
    //this.dataSource = new MatTableDataSource(this.detail);
    //this.dataSource.paginator = this.paginator;
    // this.dataSource.sort = this.sort;
  }

  getAllDetails() {
    this.service.getAllDetail().subscribe(
      (data: any[]) => {
        this.dataSource = (data);
      }
    )
  }

  deleteDetails(event) {
    this.service.deleteAll(this.selectedRows);
    this.selectedRows.forEach(function(val, args, array){
      //todo ???
        delete val.id
    })
  }

  getDetByModID() {
    const id = +this.route.snapshot.paramMap.get('id');
    this.service.getDetailsByModuleId(id).subscribe(
      (data: any[]) => {
        this.dataSource = (data);
      }
    );
  }

  openDialogCreateDetail(event) {
    console.log(this.colors);
    console.log(this.edgeMat);
    const dialogRef = this.dialog.open(DetailCreateDialogComponent, {
      width: '1000px',
      data: {colors : this.colors, edges : this.edgeMat}
    });
    dialogRef.afterClosed().subscribe(result => {
        this.name = result.name;
        this.x = result.x;
        this.y = result.y;
        this.count = result.count;
        this.thickness = result.thickness;
        this.material = result.material;
        this.edgeId = result.edgeId;
        this.colorId = result.colorId;
        this.creDetail = new Details(null,
                                         this.name,
                                         this.x,
                                         this.y,
                                         this.count,
                                         this.thickness,
                                         this.material,
                                         this.edgeId,
                                         this.colorId)
        this.save(this.creDetail);
    })

  }

  save(data){
    this.service.save(data).subscribe( data => this.dataSource.push(data));
  }

  isAllSelected() {
    const numSelected = this.selection.selected.length;
    const numRows = this.dataSource.length;
    this.selectedRows = this.selection.selected;
    return numSelected === numRows;
  }

  /** Selects all rows if they are not all selected; otherwise clear selection. */
  masterToggle() {
    this.isAllSelected() ?
      this.selection.clear() :
      this.dataSource.forEach(row => this.selection.select(<Details>row));
  }
}

@Component({
  selector: 'detail',
  template: ''
})
export class Details {
  private _id: number;
  private name: string;
  private x: string;
  private y: string;
  private count: string;
  private thickness: string;
  private material: string;
  private edgeId: number;
  private colorId: number;


  constructor(id: number, name: string, x: string, y: string, count: string, thickness: string, material: string, edgeId: number, colorId: number) {
    this._id = id;
    this.name = name;
    this.x = x;
    this.y = y;
    this.count = count;
    this.thickness = thickness;
    this.material = material;
    this.edgeId = edgeId;
    this.colorId = colorId;
  }

  get id(): number {
    return this._id;
  }

  set id(value: number) {
    this._id = value;
  }
}

