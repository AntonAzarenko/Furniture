import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DetailCreateDialogComponent } from './detail-create-dialog.component';

describe('DetailCreateDialogComponent', () => {
  let component: DetailCreateDialogComponent;
  let fixture: ComponentFixture<DetailCreateDialogComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DetailCreateDialogComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DetailCreateDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
