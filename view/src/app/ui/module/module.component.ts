import { Component, OnInit } from '@angular/core';
import {ModuleService} from "../../services/module.service";
import {ActivatedRoute} from "@angular/router";
import {DetailService} from "../../services/detail.service";
import {DetailsComponent} from "../details/details.component";

@Component({
  selector: 'app-module',
  templateUrl: './module.component.html',
  styleUrls: ['./module.component.css']
})
export class ModuleComponent implements OnInit {

  private modules: Object[];
  private id: number;
  constructor(private service: ModuleService) { }

  ngOnInit() {
    this.getAllModules();
  }

  getAllModules(){
      this.service.getAll().subscribe(
        (data:any[])=>{
          this.modules = (data)
        }
      )
  }

}
