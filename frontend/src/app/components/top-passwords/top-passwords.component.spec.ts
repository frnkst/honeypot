import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TopPasswordsComponent } from './top-passwords.component';

describe('TopPasswordsComponent', () => {
  let component: TopPasswordsComponent;
  let fixture: ComponentFixture<TopPasswordsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [TopPasswordsComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TopPasswordsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
