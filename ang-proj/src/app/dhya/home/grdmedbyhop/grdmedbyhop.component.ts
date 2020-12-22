import { Component, OnInit } from '@angular/core';
import { MessageService } from 'primeng/api';
import { MedecinService } from '../../service/medecin.service';
import {DynamicDialogRef} from 'primeng/dynamicdialog';
import {DynamicDialogConfig} from 'primeng/dynamicdialog';

import { Medecin } from '../../model/medecin';

@Component({
  selector: 'app-grdmedbyhop',
  templateUrl: './grdmedbyhop.component.html',
  styleUrls: ['./grdmedbyhop.component.css']
})
export class GrdmedbyhopComponent implements OnInit {

  medecins: Medecin[];
  hopital: string;
    // tslint:disable-next-line:max-line-length
    constructor(private medecinService: MedecinService, private messageService: MessageService, public ref: DynamicDialogRef, public config: DynamicDialogConfig) { }

    ngOnInit() {
       this.loadMedecins();
    }

    public loadMedecins() {
      this.medecinService.getMedecinsByHopital(this.hopital).pipe(
        // takeUntil(this.destroy)
      ).subscribe(
        resp => {
          this.medecins = resp;
          // tslint:disable-next-line:no-debugger
          debugger;
        },
        err => {
        }
      );
    }

}
