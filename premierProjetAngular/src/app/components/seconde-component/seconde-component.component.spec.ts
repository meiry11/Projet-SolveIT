import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SecondeComponentComponent } from './seconde-component.component';

describe('SecondeComponentComponent', () => {
  let component: SecondeComponentComponent;
  let fixture: ComponentFixture<SecondeComponentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SecondeComponentComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SecondeComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
