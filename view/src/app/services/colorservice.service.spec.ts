import { TestBed } from '@angular/core/testing';

import { ColorserviceService } from './colorservice.service';

describe('ColorserviceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ColorserviceService = TestBed.get(ColorserviceService);
    expect(service).toBeTruthy();
  });
});
