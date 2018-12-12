import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EdgeMaterialComponent } from './edge-material.component';

describe('EdgeMaterialComponent', () => {
  let component: EdgeMaterialComponent;
  let fixture: ComponentFixture<EdgeMaterialComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EdgeMaterialComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EdgeMaterialComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
