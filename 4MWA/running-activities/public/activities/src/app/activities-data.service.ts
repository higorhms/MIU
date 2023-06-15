import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from 'rxjs';

import { Benefit } from './benefits-data.service';

export class Acitivty {
  #_id!: string;
  #name!: string;
  #duration!: string;
  #description!: string;
  #benefits!: Benefit[];

  get _id() { return this.#_id };
  get name() { return this.#name };
  get duration() { return this.#duration };
  get description() { return this.#description };
  get benefits() { return this.#benefits };

  set _id(id) { this._id = id };
  set name(name) { this.#name = name };
  set duration(duration) { this.#duration = duration };
  set description(description) { this.#description = description };
  set benefits(benefits) { this.#benefits = benefits };
}

@Injectable({
  providedIn: 'root'
})
export class ActivitiesDataService {

  private _baseUrl: string = 'http://localhost:3000/api/activities/';

  constructor(private httpClient: HttpClient) { }

  getActivities(offset: number = 1, count: number = 3): Observable<Acitivty[]> {
    return this.httpClient.get<Acitivty[]>(this._baseUrl, {
      params: {
        offset,
        count
      }
    });
  }

  getActivity(activityId: string): Observable<Acitivty> {
    return this.httpClient.get<Acitivty>(this._baseUrl + activityId);
  }

  deleteActivity(activityId: string) {
    return this.httpClient.delete(this._baseUrl + activityId);
  }
}
