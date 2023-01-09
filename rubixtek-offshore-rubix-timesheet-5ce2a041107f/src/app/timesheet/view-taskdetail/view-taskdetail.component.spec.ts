import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewTaskdetailComponent } from './view-taskdetail.component';

describe('ViewTaskdetailComponent', () => {
  let component: ViewTaskdetailComponent;
  let fixture: ComponentFixture<ViewTaskdetailComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewTaskdetailComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewTaskdetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
