import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TopUsernamesComponent } from './top-usernames.component';

describe('TopUsernamesComponent', () => {
  let component: TopUsernamesComponent;
  let fixture: ComponentFixture<TopUsernamesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [TopUsernamesComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TopUsernamesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
