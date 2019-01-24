import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {
  static disabled: string;

  static disable(status: string) {
    this.disabled = status
  }

  constructor() {
  }

  ngOnInit() {
  }

}
