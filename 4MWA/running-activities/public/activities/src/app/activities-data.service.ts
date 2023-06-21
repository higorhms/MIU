import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from 'rxjs';

import { Benefit } from './benefits-data.service';
import { environment } from '../environments/environment';

export class Activity {
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

  toJSON() {
    return {
      _id: this._id,
      name: this.name,
      duration: this.duration,
      description: this.description,
      benefits: this.benefits,
    }
  }
}
@Injectable({
  providedIn: 'root'
})
export class ActivitiesDataService {

  private _baseUrl: string = `${environment.BASE_URL}/activities/`;

  constructor(
    private httpClient: HttpClient
  ) { }

  getActivities(
    offset: number = environment.DEFAULT_FIRST_PAGE,
    count: number = environment.DEFAULT_AMOUNT_OF_RESULTS
  ): Observable<Activity[]> {
    return this.httpClient.get<Activity[]>(this._baseUrl, {
      params: {
        offset,
        count
      }
    });
  }

  getActivity(activityId: string): Observable<Activity> {
    return this.httpClient.get<Activity>(this._baseUrl + activityId);
  }

  create(activity: Activity): Observable<Activity> {
    return this.httpClient.post<Activity>(this._baseUrl, activity.toJSON());
  }

  update(activityId: string, newProperties: Partial<Activity>): Observable<Activity> {
    return this.httpClient.patch<Activity>(this._baseUrl + activityId, newProperties);
  }

  deleteActivity(activityId: string) {
    return this.httpClient.delete(this._baseUrl + activityId);
  }
}
