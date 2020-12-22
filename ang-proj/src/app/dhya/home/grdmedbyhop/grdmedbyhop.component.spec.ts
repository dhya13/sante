import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GrdmedbyhopComponent } from './grdmedbyhop.component';

describe('GrdmedbyhopComponent', () => {
  let component: GrdmedbyhopComponent;
  let fixture: ComponentFixture<GrdmedbyhopComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GrdmedbyhopComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GrdmedbyhopComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
