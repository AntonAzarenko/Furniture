import { Component, OnInit } from '@angular/core';
import {EdgeMaterialServiceService} from "../../services/edge-material-service.service";

@Component({
  selector: 'app-edge-material',
  templateUrl: './edge-material.component.html',
  styleUrls: ['./edge-material.component.css']
})
export class EdgeMaterialComponent implements OnInit {

  constructor(private service: EdgeMaterialServiceService) { }

  edgeMat: Object[];
  ngOnInit() {
    this.getAll()
  }

  getAll(){
    this.service.getAllEdge().subscribe(
      (data:any[]) =>{
          this.edgeMat = (data);
      }
    )
  }
}
