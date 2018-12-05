import {Component, OnInit, ViewChild} from '@angular/core';
import {MatPaginator, MatSort, MatTableDataSource} from '@angular/material';
import {DetailService} from "../../services/detail.service";
import {ActivatedRoute} from "@angular/router";
import {SelectionModel} from "@angular/cdk/collections";


export interface DetailData {
  id: string;
  name: string;
  x: string;
  y: string;
  count: string;
  thickness: string;
  material: string;
}

/*const ELEMENT_DATA: DetailData[] = [
  {id: '1', name: '1', x: 'Hydrogen', y: '1.0079', count: 'H', thickness: '', material: ''},
];*/


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

  detId: number[];
  id: number;
  selection = new SelectionModel<Details>(true, []);


  constructor(private service: DetailService,
              private route: ActivatedRoute,) {
  }

  displayedColumns: string[] = ['select', 'name', 'x', 'y', 'count', 'thickness', 'material'];

  ngOnInit() {
    this.getDetByModID()

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
    for (var key in this.selectedRows) {
      this.service.deleteDetail(this.selectedRows[key].id)
    }
  }

  getDetByModID() {
    const id = +this.route.snapshot.paramMap.get('id');
    this.service.getDetailsByModuleId(id).subscribe(
      (data: any[]) => {
        this.dataSource = (data);
      }
    );
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


  get id(): number {
    return this._id;
  }

  set id(value: number) {
    this._id = value;
  }
}

