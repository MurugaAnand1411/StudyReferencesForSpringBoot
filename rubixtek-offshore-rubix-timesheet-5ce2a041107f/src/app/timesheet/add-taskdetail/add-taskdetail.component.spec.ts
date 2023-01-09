import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddTaskdetailComponent } from './add-taskdetail.component';

describe('AddTaskdetailComponent', () => {
  let component: AddTaskdetailComponent;
  let fixture: ComponentFixture<AddTaskdetailComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddTaskdetailComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddTaskdetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
