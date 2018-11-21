import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ColordetailComponent} from "./ui/colordetail/colordetail.component";

const routes: Routes = [
  {path: 'colors', component : ColordetailComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
