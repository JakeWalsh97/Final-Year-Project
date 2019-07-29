import { TestBed } from '@angular/core/testing';

import { SmsMessageService } from './sms-message.service';

describe('SmsMessageService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: SmsMessageService = TestBed.get(SmsMessageService);
    expect(service).toBeTruthy();
  });
});
