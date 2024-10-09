import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TopPasswordsContainerComponent } from './top-passwords-container.component';

describe('TopPasswordsContainerComponent', () => {
  let component: TopPasswordsContainerComponent;
  let fixture: ComponentFixture<TopPasswordsContainerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [TopPasswordsContainerComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TopPasswordsContainerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
