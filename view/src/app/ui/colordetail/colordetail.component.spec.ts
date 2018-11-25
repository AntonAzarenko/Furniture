import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ColordetailComponent } from './colordetail.component';

describe('ColordetailComponent', () => {
  let component: ColordetailComponent;
  let fixture: ComponentFixture<ColordetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ColordetailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ColordetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
