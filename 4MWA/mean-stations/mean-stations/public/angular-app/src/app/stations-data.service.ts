import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

import { Station } from './stations/stations.component';

@Injectable({
  providedIn: 'root'
})
export class StationsDataService {
  private apiBaseUrl: string= "http://localhost:3300/api"

  constructor(private http:HttpClient) { }

  public getStations(offset: number, count: number = 5): Observable<Station[]> {
    const url: string= this.apiBaseUrl + "/stations";
    
    return this.http.get<Station[]>(url, {
      params: {
        offset,
        count
      }
    });
  }

  public getStation(stationId: string): Observable<Station> {
    const url: string= this.apiBaseUrl + "/stations/" + stationId;
    
    return this.http.get<Station>(url);
  }

  public deleteMany(list: string[]){
    const url: string = this.apiBaseUrl + "/stations/" + list;
    return this.http.delete<any>(url)
  }

}
