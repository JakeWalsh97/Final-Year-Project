import { TestBed, async, inject } from '@angular/core/testing';

import { NeedAuthGuard } from './need-auth.guard';

describe('NeedAuthGuard', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [NeedAuthGuard]
    });
  });

  it('should ...', inject([NeedAuthGuard], (guard: NeedAuthGuard) => {
    expect(guard).toBeTruthy();
  }));
});
