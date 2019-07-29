import { TestBed } from '@angular/core/testing';

import { SearchHistoryService } from './search-history.service';

describe('SearchHistoryService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: SearchHistoryService = TestBed.get(SearchHistoryService);
    expect(service).toBeTruthy();
  });
});
