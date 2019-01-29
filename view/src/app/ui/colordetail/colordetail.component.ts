import { Component, OnInit } from '@angular/core';
import {ColorService} from "../../services/colorservice.service";
import {FormsModule} from "@angular/forms";

@Component({
  selector: 'app-colorDetail',
  templateUrl: './colorDetail.component.html',
  styleUrls: ['./colorDetail.component.css']
})
export class ColorDetailComponent implements OnInit {

  public colors: Object;
  public idColor: number ;

  constructor(private service: ColorService) { }

  ngOnInit() {
    this.getAll();
  }


  getAll(){
    this.service.getAllColorMaterial().subscribe(
      (data:any[])=>{
      this.colors =  (data)
    });
  }

}


