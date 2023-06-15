import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

export class Benefit {
  #_id!: string;
  #name!: string;
  #description!: string;

  get _id() { return this.#_id };
  get name() { return this.#name };
  get description() { return this.#description };

  set _id(id) { this._id = id };
  set name(name) { this.#name = name };
  set description(description) { this.#description = description };
}

@Injectable({
  providedIn: 'root'
})
export class BenefitsDataService {
  constructor(
    private _httpClient: HttpClient,
  ) { }

  delete(activityId: string, benefitId: string) {
    return this._httpClient.delete(this._buildUrl(activityId, benefitId));
  }

  getOne(activityId: string, benefitId: string) {
    return this._httpClient.get<Benefit>(this._buildUrl(activityId, benefitId));
  }

  _buildUrl(activityId: string, benefitId: string) {
    return `http://localhost:3000/api/activities/${activityId}/benefits/${benefitId}`;
  }
}
