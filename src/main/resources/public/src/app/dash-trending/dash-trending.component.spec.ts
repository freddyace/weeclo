import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DashTrendingComponent } from './dash-trending.component';

describe('DashTrendingComponent', () => {
  let component: DashTrendingComponent;
  let fixture: ComponentFixture<DashTrendingComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DashTrendingComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DashTrendingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
