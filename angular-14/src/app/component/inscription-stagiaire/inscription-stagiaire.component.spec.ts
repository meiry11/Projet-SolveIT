import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InscriptionStagiaireComponent } from './inscription-stagiaire.component';

describe('InscriptionStagiaireComponent', () => {
  let component: InscriptionStagiaireComponent;
  let fixture: ComponentFixture<InscriptionStagiaireComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InscriptionStagiaireComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(InscriptionStagiaireComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
