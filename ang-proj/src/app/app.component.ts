import { Component } from '@angular/core';
import { PrimeNGConfig } from 'primeng/api';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'ang-proj';
  constructor(private primengConfig: PrimeNGConfig) {}

    // tslint:disable-next-line:use-lifecycle-interface
    ngOnInit() {
        this.primengConfig.ripple = true;
    }
}
