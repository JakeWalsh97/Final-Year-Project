import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SmsMessageComponent } from './sms-message.component';

describe('SmsMessageComponent', () => {
  let component: SmsMessageComponent;
  let fixture: ComponentFixture<SmsMessageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SmsMessageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SmsMessageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
