import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TopPasswordsPresentationComponent } from './top-passwords-presentation.component';

describe('TopPasswordsPresentationComponent', () => {
  let component: TopPasswordsPresentationComponent;
  let fixture: ComponentFixture<TopPasswordsPresentationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [TopPasswordsPresentationComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TopPasswordsPresentationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
