import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TimesheetApprovalListComponent } from './timesheet-approval-list.component';

describe('TimesheetApprovalListComponent', () => {
  let component: TimesheetApprovalListComponent;
  let fixture: ComponentFixture<TimesheetApprovalListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TimesheetApprovalListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TimesheetApprovalListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
