import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DashFavoritesComponent } from './dash-favorites.component';

describe('DashFavoritesComponent', () => {
  let component: DashFavoritesComponent;
  let fixture: ComponentFixture<DashFavoritesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DashFavoritesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DashFavoritesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
