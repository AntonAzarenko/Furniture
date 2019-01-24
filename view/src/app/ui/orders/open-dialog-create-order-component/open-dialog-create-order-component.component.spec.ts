import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OpenDialogCreateOrderComponentComponent } from './open-dialog-create-order-component.component';

describe('OpenDialogCreateOrderComponentComponent', () => {
  let component: OpenDialogCreateOrderComponentComponent;
  let fixture: ComponentFixture<OpenDialogCreateOrderComponentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OpenDialogCreateOrderComponentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OpenDialogCreateOrderComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
