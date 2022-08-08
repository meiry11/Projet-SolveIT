import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormulaireEmargementComponent } from './formulaire-emargement.component';

describe('FormulaireEmargementComponent', () => {
  let component: FormulaireEmargementComponent;
  let fixture: ComponentFixture<FormulaireEmargementComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FormulaireEmargementComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FormulaireEmargementComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
