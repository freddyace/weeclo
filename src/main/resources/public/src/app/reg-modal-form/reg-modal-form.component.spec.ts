import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RegModalFormComponent } from './reg-modal-form.component';

describe('RegModalFormComponent', () => {
  let component: RegModalFormComponent;
  let fixture: ComponentFixture<RegModalFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RegModalFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RegModalFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
