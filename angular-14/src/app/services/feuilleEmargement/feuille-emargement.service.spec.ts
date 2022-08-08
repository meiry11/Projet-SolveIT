import { TestBed } from '@angular/core/testing';

import { FeuilleEmargementService } from './feuille-emargement.service';

describe('FeuilleEmargementService', () => {
  let service: FeuilleEmargementService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(FeuilleEmargementService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
