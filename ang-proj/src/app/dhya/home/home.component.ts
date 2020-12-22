import { Component, OnChanges, OnInit, SimpleChanges } from '@angular/core';
import {MenuItem} from 'primeng/api';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.sass']
})
export class HomeComponent implements OnInit, OnChanges {

  date1: Date;
  items2: MenuItem[];

    items3: MenuItem[];
    testInputFather: string = 'rstValue';
    activeItem: MenuItem;

    constructor(route: ActivatedRoute, router: Router) {
    }
  ngOnChanges(changes: SimpleChanges): void {debugger
    console.log('ngOnChanges: HomeComponent');
  }

    ngOnInit() {
      this.items2 = [
          {label: 'Hopital', icon: 'pi pi-fw pi-bell', routerLink: 'hopital'},
          {label: 'Medecins', icon: 'pi pi-fw pi-user', routerLink: 'medecins'},
          {label: 'Infrmiers', icon: 'pi pi-fw pi-calendar', routerLink: 'infirmiers'}
      ];
      this.activeItem = this.items2[0];
    }
    closeItem(event, index) {
      this.items2 = this.items2.filter((item, i) => i !== index);
      event.preventDefault();
  }

}
