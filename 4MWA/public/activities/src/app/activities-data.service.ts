import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from 'rxjs';

class Benefit {
  constructor(
    public _id: string,
    public name: string,
    public description: string
  ) { }
}

export class Acitivty {
  constructor(
    public _id: string,
    public name: string,
    public duration: string,
    public description: string,
    public benefits: Benefit[]
  ) { }
}

@Injectable({
  providedIn: 'root'
})
export class ActivitiesDataService {

  private _baseUrl: string = 'http://localhost:3000/api/activities';

  constructor(private httpClient: HttpClient) { }

  getActivities(): Observable<Acitivty[]> {
    return this.httpClient.get<Acitivty[]>(this._baseUrl);
  }

  getActivity(activityId: string): Observable<Acitivty> {
    return this.httpClient.get<Acitivty>(this._baseUrl + "/" + activityId);
  }

  deleteActivity(activityId: string) {
    return this.httpClient.delete(this._baseUrl + "/" + activityId);
  }
}
