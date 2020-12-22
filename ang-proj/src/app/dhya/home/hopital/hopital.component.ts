import { Component, OnInit, OnDestroy, OnChanges, SimpleChanges, AfterContentInit, AfterContentChecked, Input, DoCheck, AfterViewInit } from '@angular/core';
import { Hopital } from '../../model/Hopital';
import { HopitalService } from '../../service/hopital.service';
import { MessageService } from 'primeng/api';
import {DialogService} from 'primeng/dynamicdialog';
import { MedecinService } from '../../service/medecin.service';
import { Medecin } from '../../model/medecin';

// import {Subject} from "rxjs";

@Component({
  selector: 'app-hopital',
  templateUrl: './hopital.component.html',
  styleUrls: ['./hopital.component.css'],
  providers: [MessageService]
})
export class HopitalComponent implements OnInit, OnChanges, AfterContentInit, AfterContentChecked, AfterViewInit {

  hospitals: Hopital[];
  selectedHopital: Hopital;
  @Input()
  testInputFather: any;
  selectedLabelHopital: string = '';
  display: boolean = false;
  modal: boolean = true;
  public medecins: Medecin[];
  public hopital: string;
    constructor(private medecinService: MedecinService, private hopitalService: HopitalService, private messageService: MessageService) { }
  ngAfterViewInit(): void {
    console.log('ngAfterViewInit method ..');
  }
   ngOnChanges(changes: SimpleChanges): void {
    console.log('ngOnChanges method ..');
  }

    /* ngDoCheck(){
      console.log('ngDoCheckMethod');
          } */
    ngAfterContentChecked(): void {
    console.log('ngAfterContentChecked Method');
  }
  ngAfterContentInit(): void {
    console.log('ngAfterContentInit method');
  }

/*
    ngOnChanges(changes: SimpleChanges): void {
       console.log(changes);
    }*/

    ngOnInit() {
      console.log('Init method');
       this.loadHospitals();
    }
    showDialog() {
      this.display = true;
  }

    public loadHospitals() {
      this.hopitalService.getAllHospitals2().pipe(
        // takeUntil(this.destroy)
      ).subscribe(
        resp => {
          this.hospitals = resp;
        },
        err => {
        }
      );
    }


    public onClickHop( hop: Hopital ): void {
      this.loadMedecins(hop.name);
      this.selectedLabelHopital = hop.labelName;
      this.showDialog();
    }

    public loadMedecins(name) {
      this.medecinService.getMedecinsByHopital(name).pipe(
        // takeUntil(this.destroy)
      ).subscribe(
        resp => {
          this.medecins = resp;
        },
        err => {
        }
      );
    }

}
