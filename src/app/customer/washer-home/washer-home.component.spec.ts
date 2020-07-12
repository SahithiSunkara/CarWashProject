import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { WasherHomeComponent } from './washer-home.component';

describe('WasherHomeComponent', () => {
  let component: WasherHomeComponent;
  let fixture: ComponentFixture<WasherHomeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ WasherHomeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(WasherHomeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
