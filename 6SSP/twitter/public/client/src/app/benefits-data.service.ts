import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

import { environment } from '../environments/environment';

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

  toJSON() {
    return {
      _id: this._id,
      name: this.name,
      description: this.description,
    }
  }
}

@Injectable({
  providedIn: 'root'
})
export class BenefitsDataService {

  constructor(
    private _httpClient: HttpClient,
  ) { }

  create(activityId: string, newBenefit: Benefit) {
    return this._httpClient.post<Benefit>(this._buildUrl(activityId), newBenefit.toJSON());
  }

  delete(activityId: string, benefitId: string) {
    return this._httpClient.delete(this._buildUrl(activityId) + benefitId);
  }

  getOne(activityId: string, benefitId: string) {
    return this._httpClient.get<Benefit>(this._buildUrl(activityId) + benefitId);
  }

  update(activityId: string, benefitId: string, newProperties: Benefit) {
    return this._httpClient.patch<Benefit>(this._buildUrl(activityId) + benefitId, newProperties.toJSON());
  }

  _buildUrl(activityId: string) {
    return `${environment.BASE_URL}/activities/${activityId}/benefits/`;
  }
}
