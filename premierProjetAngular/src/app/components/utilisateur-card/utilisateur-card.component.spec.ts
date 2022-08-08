import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UtilisateurCardComponent } from './utilisateur-card.component';

describe('UtilisateurCardComponent', () => {
  let component: UtilisateurCardComponent;
  let fixture: ComponentFixture<UtilisateurCardComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UtilisateurCardComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UtilisateurCardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
