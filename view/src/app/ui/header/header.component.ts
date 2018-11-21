import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor() { }


  car:Car = new Car();
  colours = Array<Colour>();

  ngOnInit() {

    this.colours = Array<Colour>();
    this.colours.push(new Colour(-1, 'Please select'));
    this.colours.push(new Colour(1, 'Green'));
    this.colours.push(new Colour(2, 'Pink'));
    this.colours.push(new Colour(3, 'Orange'));
    this.colours.push(new Colour(4, 'Black'));

    this.car = new Car();
    this.car.color = new Colour(-1,'');
  }
}

export class Car
{
  color:Colour;
}

export class Colour
{
  constructor(id:number, name:string) {
    this.id=id;
    this.name=name;
  }

  id:number;
  name:string;

}
