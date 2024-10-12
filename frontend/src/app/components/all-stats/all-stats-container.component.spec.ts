import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AllStatsContainerComponent } from './all-stats-container.component';

describe('AllStatsContainerComponent', () => {
  let component: AllStatsContainerComponent;
  let fixture: ComponentFixture<AllStatsContainerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AllStatsContainerComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AllStatsContainerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
