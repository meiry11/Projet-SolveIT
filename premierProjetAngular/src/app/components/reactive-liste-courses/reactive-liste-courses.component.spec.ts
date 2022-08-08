import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ReactiveListeCoursesComponent } from './reactive-liste-courses.component';

describe('ReactiveListeCoursesComponent', () => {
  let component: ReactiveListeCoursesComponent;
  let fixture: ComponentFixture<ReactiveListeCoursesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ReactiveListeCoursesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ReactiveListeCoursesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
