import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { LayoutComponent } from './layout/layout.component';
import {AppRoutingModule} from "../app-routing.module";
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {ColordetailComponent} from "./colordetail/colordetail.component";
import {DetailComponent} from "./detail/detail.component";
import {DetailsComponent} from "./details/details.component";
import {MatPaginatorModule, MatRowDef, MatSortModule, MatTableModule} from "@angular/material";

@NgModule({
  declarations: [HeaderComponent, FooterComponent, LayoutComponent,ColordetailComponent, DetailComponent,DetailsComponent],
  imports: [
    NgbModule,
    CommonModule,
    AppRoutingModule,


  ],
  exports:[HeaderComponent,FooterComponent,LayoutComponent, ColordetailComponent, DetailComponent,DetailsComponent]

})
export class UiModule { }
