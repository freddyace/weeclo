import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DashRecommendedComponent } from './dash-recommended.component';

describe('DashRecommendedComponent', () => {
  let component: DashRecommendedComponent;
  let fixture: ComponentFixture<DashRecommendedComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DashRecommendedComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DashRecommendedComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
