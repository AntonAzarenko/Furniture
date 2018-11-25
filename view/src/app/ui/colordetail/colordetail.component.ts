import { Component, OnInit } from '@angular/core';
import {ColorserviceService} from "../../services/colorservice.service";
import {FormsModule} from "@angular/forms";

@Component({
  selector: 'app-colordetail',
  templateUrl: './colordetail.component.html',
  styleUrls: ['./colordetail.component.css']
})
export class ColordetailComponent implements OnInit {

  private colors: Object;
  private idcolor: number ;

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


