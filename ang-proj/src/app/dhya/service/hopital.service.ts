import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Hopital } from '../model/Hopital';
import {Observable} from 'rxjs/Observable';

@Injectable()
export class HopitalService {

  constructor(private http: HttpClient) { }


    getAllHospitals2(): Observable<Hopital[]> {
      return this.http.get<Hopital[]>('http://192.168.1.16:8083/api/sante/hopitals');
    }
}
