import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AllStatsPresentationComponent } from './all-stats-presentation.component';

describe('AllStatsPresentationComponent', () => {
  let component: AllStatsPresentationComponent;
  let fixture: ComponentFixture<AllStatsPresentationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AllStatsPresentationComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AllStatsPresentationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
