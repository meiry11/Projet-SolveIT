import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TableEmargementComponent } from './table-emargement.component';

describe('TableEmargementComponent', () => {
  let component: TableEmargementComponent;
  let fixture: ComponentFixture<TableEmargementComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TableEmargementComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TableEmargementComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
