import {ChangeDetectorRef, Component, OnInit, ViewChild} from '@angular/core';
import {MatDialog, MatPaginator, MatSort, MatTableDataSource} from '@angular/material';
import {DetailService} from "../../services/detail.service";
import {ActivatedRoute} from "@angular/router";
import {SelectionModel} from "@angular/cdk/collections";
import {DetailCreateDialogComponent} from "./detail-create-dialog/detail-create-dialog.component";
import {ColorserviceService} from "../../services/colorservice.service";
import {EdgeMaterialServiceService} from "../../services/edge-material-service.service";
import {FormControl} from '@angular/forms';

export interface DetailData {
  id: number;
  name: string;
  x: string;
  y: string;
  count: string;
  thickness: string;
  material: string;
  edgeTypeY: string;
  edgeTypeX: string;
  edgeSideX: string;
  edgeSideY: string;
  colorEdgeX: string;
  colorEdgeY: string;
  moduleId: number;
}


@Component({
  selector: 'app-details',
  templateUrl: './details.component.html',
  styleUrls: ['./details.component.css'],
})
export class DetailsComponent implements OnInit {
  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;
  formControl = new FormControl();

  dataSource: Details[];
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
  private colorId: number;
  private edgeTypeY: string;
  private edgeTypeX: string;
  private edgeSideX: string;
  private edgeSideY: string;
  private colorEdgeX: string;
  private colorEdgeY: string;
  private moduleId: number;

  selection = new SelectionModel<Details>(true, []);


  constructor(private service: DetailService,
              private colorService: ColorserviceService,
              private edgeService: EdgeMaterialServiceService,
              private route: ActivatedRoute,
              private  changeDetectorRefs: ChangeDetectorRef,
              public dialog: MatDialog) {
  }

  displayedColumns: string[] = ['select', 'name', 'x', 'y', 'count', 'thickness', 'material'];

  ngOnInit() {
    this.getDetByModID();
    this.colorService.getAllColorMaterail().subscribe((data: any[]) => {
      this.colors = (data)
    });
    this.edgeService.getAllEdge().subscribe(
      (data: any[]) => {
        this.edgeMat = (data);
      }
    )
  }

  getAllDetails() {
    this.service.getAllDetail().subscribe(
      (data: any[]) => {
        this.dataSource = (data);
      }
    )
  }

  deleteDetails(event) {
    let id: number;
    for(let el of this.selectedRows){
      this.service.deleteDetail(el.id);
      this.dataSource.splice(el.id,1);
      this.changeDetectorRefs.detectChanges();
    }
  }

  getDetByModID() {
    const id = +this.route.snapshot.paramMap.get('id');
    this.moduleId = id;
    console.log(id);
    this.service.getDetailsByModuleId(id).subscribe(
      (data: any[]) => {
        this.dataSource = (data);
      }
    );
  }

  openDialogCreateDetail(event) {
    const dialogRef = this.dialog.open(DetailCreateDialogComponent, {
      width: '1000px',
      data: {colors: this.colors}
    });
    dialogRef.afterClosed().subscribe(result => {
      console.log(result);
      this.name = result.name;
      this.x = result.x;
      this.y = result.y;
      this.count = result.count;
      this.thickness = result.thickness;
      this.material = result.material;
      this.colorId = result.colorId;
      this.edgeTypeY = result.edgeTypeY;
      this.edgeTypeX = result.edgeTypeX;
      this.edgeSideX = result.edgeSideX;
      this.edgeSideY = result.edgeSideY;
      this.colorEdgeX = result.colorEdgeX;
      this.colorEdgeY = result.colorEdgeY;
      this.moduleId = +this.route.snapshot.paramMap.get('id');
      this.creDetail = new Details(null,
        this.name,
        this.x,
        this.y,
        this.count,
        this.thickness,
        this.material,
        this.colorId,
        this.edgeTypeY,
        this.edgeTypeX,
        this.edgeSideX,
        this.edgeSideY,
        this.colorEdgeX,
        this.colorEdgeY,
        this.moduleId);
      this.save(this.creDetail);
    });
  }

  save(data) {
    this.service.save(data).subscribe((data: any) => {
      this.dataSource.push(data);
    });
    this.paginator._changePageSize(this.paginator.pageSize);
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
   id: number;
  private name: string;
  private x: string;
  private y: string;
  private count: string;
  private thickness: string;
  private material: string;
  private colorId: number;
  private edgeTypeY: string;
  private edgeTypeX: string;
  private edgeSideX: string;
  private edgeSideY: string;
  private colorEdgeX: string;
  private colorEdgeY: string;
  private moduleId: number;


  constructor(id: number, name: string, x: string, y: string, count: string, thickness: string, material: string,
              colorId: number, edgeTypeY: string, edgeTypeX: string, edgeSideX: string, edgeSideY: string,
              colorEdgeX: string, colorEdgeY: string, moduleId: number) {
    this.id = id;
    this.name = name;
    this.x = x;
    this.y = y;
    this.count = count;
    this.thickness = thickness;
    this.material = material;
    this.colorId = colorId;
    this.edgeTypeY = edgeTypeY;
    this.edgeTypeX = edgeTypeX;
    this.edgeSideX = edgeSideX;
    this.edgeSideY = edgeSideY;
    this.colorEdgeX = colorEdgeX;
    this.colorEdgeY = colorEdgeY;
    this.moduleId = moduleId;
  }
}

