import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DataCoursesComponent } from './data-courses.component';

describe('DataCoursesComponent', () => {
  let component: DataCoursesComponent;
  let fixture: ComponentFixture<DataCoursesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DataCoursesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DataCoursesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
