import {CUSTOM_ELEMENTS_SCHEMA, NgModule, NO_ERRORS_SCHEMA} from '@angular/core';
import { CommonModule } from '@angular/common';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { LayoutComponent } from './layout/layout.component';
import {AppRoutingModule} from "../app-routing.module";
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {ColordetailComponent} from "./colordetail/colordetail.component";
import {DetailsComponent} from "./details/details.component";
import {MatPaginatorModule,  MatSortModule, MatTableModule} from "@angular/material";
import {FormsModule} from "@angular/forms";
import {BrowserAnimationsModule, NoopAnimationsModule} from "@angular/platform-browser/animations";
import { ModuleComponent } from './module/module.component';
import { GreetingComponent } from './greeting/greeting.component';

@NgModule({
  declarations: [HeaderComponent, FooterComponent, LayoutComponent,ColordetailComponent, DetailsComponent,
    ModuleComponent,
    GreetingComponent],
  imports: [
    NgbModule,
    CommonModule,
    AppRoutingModule,
    MatTableModule,
    MatPaginatorModule,
    MatSortModule,
    FormsModule,
    BrowserAnimationsModule,
    NoopAnimationsModule
  ],
  schemas: [CUSTOM_ELEMENTS_SCHEMA, NO_ERRORS_SCHEMA],
  exports:[HeaderComponent,FooterComponent,LayoutComponent, ColordetailComponent, DetailsComponent,
    ModuleComponent]

})
export class UiModule { }
