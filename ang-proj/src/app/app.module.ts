import { BrowserModule } from '@angular/platform-browser';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { HomeComponent } from './dhya/home/home.component';
import {TabViewModule} from 'primeng/tabview';
import { HopitalComponent } from './dhya/home/hopital/hopital.component';
import { MedecinsComponent } from './dhya/home/medecins/medecins.component';
import { InfirmiersComponent } from './dhya/home/infirmiers/infirmiers.component';
import { Routes, RouterModule } from '@angular/router';
import { AppRoutingModule } from './app-routing.module';

import { FormsModule } from '@angular/forms';

import { HopitalService } from './dhya/service/hopital.service';
import {TabMenuModule} from 'primeng/tabmenu';
import {TableModule} from 'primeng/table';
import {ButtonModule} from 'primeng/button';
import {DynamicDialogModule} from 'primeng/dynamicdialog';
import { MedecinService } from './dhya/service/medecin.service';
import { GrdmedbyhopComponent } from './dhya/home/grdmedbyhop/grdmedbyhop.component';
import {DialogModule} from 'primeng/dialog';
import { ChildtestComponent } from './dhya/home/childtest/childtest.component';
import { DhyapipePipe } from './dhya/pipes/dhyapipe.pipe';

const routes: Routes = [
  { path: '', component: HopitalComponent },
  { path: 'hopital', component: HopitalComponent },
  { path: 'infirmiers', component: InfirmiersComponent },
  { path: 'medecins', component: MedecinsComponent }
];

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    HopitalComponent,
    MedecinsComponent,
    InfirmiersComponent,
    GrdmedbyhopComponent,
    ChildtestComponent,
    DhyapipePipe
  ],
  imports: [
    [RouterModule.forRoot(routes)],
    HttpClientModule,
    BrowserModule,
    BrowserAnimationsModule,
    FormsModule,
    TabViewModule,
    AppRoutingModule,
    TabMenuModule,
    TableModule,
    ButtonModule,
    DynamicDialogModule,
    DialogModule

  ],
  providers: [HopitalService, MedecinService],
  bootstrap: [AppComponent]
})

export class AppModule { }
