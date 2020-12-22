import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Medecin } from '../model/medecin';
import {Observable} from 'rxjs/Observable';

@Injectable({
  providedIn: 'root'
})
export class MedecinService {

  constructor(private http: HttpClient) { }

  getAllMedecins(): Observable<Medecin[]> {
    return this.http.get<Medecin[]>('http://192.168.1.16:8083/api/sante/medecins');
  }

  getMedecinsByHopital(id: string): Observable<Medecin[]> {
    return this.http.get<Medecin[]>('http://192.168.1.16:8083/api/sante/medecins/hopital/' + id);
  }
}
