import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RecentAttacksComponent } from './recent-attacks.component';

describe('RecentAttacksComponent', () => {
  let component: RecentAttacksComponent;
  let fixture: ComponentFixture<RecentAttacksComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [RecentAttacksComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RecentAttacksComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
