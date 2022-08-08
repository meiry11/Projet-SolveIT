import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormbuiledListeCoursesComponent } from './formbuiled-liste-courses.component';

describe('FormbuiledListeCoursesComponent', () => {
  let component: FormbuiledListeCoursesComponent;
  let fixture: ComponentFixture<FormbuiledListeCoursesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FormbuiledListeCoursesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FormbuiledListeCoursesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
