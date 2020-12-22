import { Component, OnInit } from '@angular/core';
import { MessageService } from 'primeng/api';
import { Infirmier } from '../../model/infirmier';
import { InfirmierService } from '../../service/infirmier.service';

@Component({
  selector: 'app-infirmiers',
  templateUrl: './infirmiers.component.html',
  styleUrls: ['./infirmiers.component.css'],
  providers: [InfirmierService, MessageService  ]
})
export class InfirmiersComponent implements OnInit {

  Infirmiers: Infirmier[];
  selectedInfirmier: Infirmier = new Infirmier();
  selectedLabelInfirmier: string = '';
  displayModifier: boolean = false;
  modal: boolean = true;
  public infirmiers: Infirmier[];
  public infirmier: string;
  
  constructor(private infirmierService: InfirmierService, private messageService: MessageService) { }

  ngOnInit(): void {
    this.loadInfirmiers();
  }

  public loadInfirmiers() {
    this.infirmierService.getAllInfirmiers().pipe(
      // takeUntil(this.destroy)
    ).subscribe(
      resp => {
        this.infirmiers = resp;
      },
      err => {
      }
    );
  }

  public showDialogModifier(infirmier: Infirmier) {
    this.selectedInfirmier = infirmier;
    this.displayModifier = true;
}

public reject(){
  this.displayModifier = false;
}

public modifierInfirmier(){
  this.infirmierService.update(this.selectedInfirmier);
  this.loadInfirmiers();
  this.displayModifier = false;
  this.selectedInfirmier = new Infirmier();
}

}
