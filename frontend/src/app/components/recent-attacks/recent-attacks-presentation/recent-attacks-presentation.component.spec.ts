import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RecentAttacksPresentationComponent } from './recent-attacks-presentation.component';

describe('RecentAttacksPresentationComponent', () => {
  let component: RecentAttacksPresentationComponent;
  let fixture: ComponentFixture<RecentAttacksPresentationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [RecentAttacksPresentationComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RecentAttacksPresentationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
