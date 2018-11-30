import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {ColordetailComponent} from "./ui/colordetail/colordetail.component";
import {DetailsComponent} from "./ui/details/details.component";
import {ModuleComponent} from "./ui/module/module.component";
import {GreetingComponent} from "./ui/greeting/greeting.component";

const routes: Routes = [
  {path: '', redirectTo: '/greeting', pathMatch: 'full'},
  {path: 'greeting', component: GreetingComponent},
  {path: 'colors', component: ColordetailComponent},
  {path: 'details', component: DetailsComponent},
  {path: 'modules', component: ModuleComponent},
  {path: 'modules/:id/details', component: DetailsComponent},
  {path: 'modules/:id', component : ModuleComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
