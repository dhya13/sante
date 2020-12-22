import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Infirmier } from '../model/infirmier';
import {Observable} from 'rxjs/Observable';

@Injectable({
  providedIn: 'root'
})
export class InfirmierService {

  constructor(private http: HttpClient) { }

  getAllInfirmiers(): Observable<Infirmier[]> {
    return this.http.get<Infirmier[]>('http://192.168.1.16:8083/api/sante/infirmiers');
  }

  getInfirmiersByHopital(id: string): Observable<Infirmier[]> {
    return this.http.get<Infirmier[]>('http://192.168.1.16:8083/api/sante/infirmiers/hopital/' + id);
  }

  update(infirmier: Infirmier): Observable<any> {
    console.log("update infirmier");
    return this.http.post<any>('http://192.168.1.16:8083/api/sante/infirmiers/', infirmier).pipe();
  }


  create(infirmier: Infirmier): Observable<any> {
    console.log("Create infirmier");
    return this.http.post<any>('http://192.168.1.16:8083/api/sante/infirmiers/', infirmier).pipe();
  }
}
