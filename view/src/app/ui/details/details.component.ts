import {Component, OnInit, ViewChild} from '@angular/core';
import {MatPaginator, MatSort, MatTableDataSource} from '@angular/material';
import {DetailService} from "../../services/detail.service";
import {ActivatedRoute} from "@angular/router";


export interface DetailData {
  id: string;
  name: string;
  x: string;
  y: string;
  count: string;
  thickness: string;
  material: string;
}

const ELEMENT_DATA: DetailData[] = [
  {id: '1', name: '1', x: 'Hydrogen', y: '1.0079', count: 'H', thickness: '', material: ''},
];


@Component({
  selector: 'app-details',
  templateUrl: './details.component.html',
  styleUrls: ['./details.component.css'],
})
export class DetailsComponent implements OnInit {
  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;
  //dataSource: MatTableDataSource<DetailData>;
  dataSource: Object[];

  id: number;


  constructor(private service: DetailService,
              private route: ActivatedRoute,) {

    // Assign the data to the data source for the table to render

  }

  /** Columns displayed in the table. Columns IDs can be added, removed, or reordered. */
  displayedColumns: string[] = ['name', 'x', 'y', 'count', 'thickness', 'material'];

  ngOnInit() {
    const idP = +this.route.snapshot.paramMap.get('id');
    if(idP == 0)
    this.getAllDetails();
    else {
      this.id = idP;
      this.getDetByModID()
    }
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

  getDetByModID() {
    this.service.getDetailsByModuleId(this.id).subscribe(
      (data: any[]) => {
        this.dataSource = (data);
      }
    );
  }


}

