import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TopPresentationComponent } from './top-presentation.component';

describe('TopPasswordsPresentationComponent', () => {
  let component: TopPresentationComponent;
  let fixture: ComponentFixture<TopPresentationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [TopPresentationComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TopPresentationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
