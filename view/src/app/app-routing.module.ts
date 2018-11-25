import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ColordetailComponent} from "./ui/colordetail/colordetail.component";
import {DetailComponent} from "./ui/detail/detail.component";
import {DetailsComponent} from "./ui/details/details.component";

const routes: Routes = [
  {path: 'colors', component : ColordetailComponent},
  {path: 'details', component: DetailsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
