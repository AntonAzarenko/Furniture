import { TestBed } from '@angular/core/testing';

import { EdgeMaterialServiceService } from './edge-material-service.service';

describe('EdgeMaterialServiceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: EdgeMaterialServiceService = TestBed.get(EdgeMaterialServiceService);
    expect(service).toBeTruthy();
  });
});
