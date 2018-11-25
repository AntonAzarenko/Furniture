import { Component, OnInit } from '@angular/core';
import {DetailService} from "../../services/detail.service";

@Component({
  selector: 'app-detail',
  templateUrl: './detail.component.html',
  styleUrls: ['./detail.component.css']
})
export class DetailComponent implements OnInit {

  private  detail: Object[];
  constructor(private service: DetailService) { }

  ngOnInit() {
    this.getAllDetails();
  }

  getAllDetails(){
    this.service.getAllDetail().subscribe(
      (data:any[])=>{
        this.detail = data;
      }
    )
  }

}
