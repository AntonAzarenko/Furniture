import { Component, OnInit } from '@angular/core';
import {ColorserviceService} from "../../services/colorservice.service";
import {FormsModule} from "@angular/forms";

@Component({
  selector: 'app-colorDetail',
  templateUrl: './colorDetail.component.html',
  styleUrls: ['./colorDetail.component.css']
})
export class ColorDetailComponent implements OnInit {

  private colors: Object;
  public idColor: number ;

  constructor(private service: ColorserviceService) { }

  ngOnInit() {
    this.getAll();
  }


  getAll(){
    this.service.getAllColorMaterail().subscribe(
      (data:any[])=>{
      this.colors =  (data)
    });
  }

}


