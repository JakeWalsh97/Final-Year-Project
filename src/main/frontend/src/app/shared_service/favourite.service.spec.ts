import { TestBed } from '@angular/core/testing';

import { FavouriteService } from './favourite.service';

describe('FavouriteService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: FavouriteService = TestBed.get(FavouriteService);
    expect(service).toBeTruthy();
  });
});
