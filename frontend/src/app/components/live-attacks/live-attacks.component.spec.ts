import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LiveAttacksComponent } from './live-attacks.component';

describe('LiveAttacksComponent', () => {
  let component: LiveAttacksComponent;
  let fixture: ComponentFixture<LiveAttacksComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [LiveAttacksComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(LiveAttacksComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
