import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TopIpsComponent } from './top-ips.component';

describe('TopIpsComponent', () => {
  let component: TopIpsComponent;
  let fixture: ComponentFixture<TopIpsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [TopIpsComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TopIpsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
