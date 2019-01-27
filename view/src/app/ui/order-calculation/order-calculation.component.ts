import {Component, OnInit} from '@angular/core';
import {animate, state, style, transition, trigger} from "@angular/animations";
import {OrderCalculationService} from "../../services/order-calculation.service";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-order-calculation',
  templateUrl: './order-calculation.component.html',
  styleUrls: ['./order-calculation.component.css'],
  animations: [
    trigger('detailExpand', [
      state('collapsed', style({height: '0px', minHeight: '0', display: 'none'})),
      state('expanded', style({height: '*'})),
      transition('expanded <=> collapsed', animate('225ms cubic-bezier(0.4, 0.0, 0.2, 1)')),
    ]),
  ],
})
export class OrderCalculationComponent implements OnInit {

  dataSource: Object[];
  displayedColumns: string [] = ['moduleName', 'moduleType', "dspM2", "dvpM2", "edgeM", "fittings", "facades", "total"];

  constructor(private service: OrderCalculationService,
              private route: ActivatedRoute) {
  }

  ngOnInit() {
    const id = +this.route.snapshot.paramMap.get('id');
    this.getCalcOfOrder(id);
  }

  getCalcOfOrder(id: number) {
    this.service.getCalculationOFOrder(id).subscribe((data: any[]) => {
      this.dataSource = data;
    })
  }
}
