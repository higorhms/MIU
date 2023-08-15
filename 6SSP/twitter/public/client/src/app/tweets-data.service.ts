import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

import { environment } from '../environments/environment';
import { User } from './users-data.service';

export class Tweet {
  #_id?: string;
  #description!: string;
  #date!: string;
  #author!: User;

  get _id() { return this.#_id };
  get description() { return this.#description };
  get date() { return this.#date };
  get author() { return this.#author };

  set _id(id) { this._id = id };
  set description(description) { this.#description = description };
  set date(date) { this.#date = date };
  set author(author) { this.#author = author };
}

@Injectable({
  providedIn: 'root'
})
export class TweetsDataService {

  constructor(
    private _httpClient: HttpClient,
  ) { }

  getAll(page: number) {
    return this._httpClient.get<Tweet[]>(this._buildUrl(), {params:{ offset: page }});
  }

  create(description: string) {
    return this._httpClient.post<Tweet>(this._buildUrl(), { description });
  }

  _buildUrl() {
    return `${environment.BASE_URL}/tweets`;
  }
}
