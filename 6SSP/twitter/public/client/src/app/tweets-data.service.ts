import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

import { environment } from '../environments/environment';
import { User } from './users-data.service';

export class Tweet {
  #_id?: string;
  #description!: string;
  #author!: User;

  get _id() { return this.#_id };
  get description() { return this.#description };
  get author() { return this.#author };

  set _id(id) { this._id = id };
  set description(description) { this.#description = description };
  set author(author) { this.#author = author };

  toJSON() {
    return {
      _id: this._id,
      description: this.description,
    }
  }
}

@Injectable({
  providedIn: 'root'
})
export class TweetsDataService {

  constructor(
    private _httpClient: HttpClient,
  ) { }

  getAll() {
    return this._httpClient.get<Tweet[]>(this._buildUrl());
  }

  create(description: string) {
    return this._httpClient.post<Tweet>(this._buildUrl(), {description});
  }

  delete(tweetId: string) {
    return this._httpClient.delete(this._buildUrl() + tweetId);
  }

  getOne(tweetId: string) {
    return this._httpClient.get<Tweet>(this._buildUrl() + tweetId);
  }

  update(tweetId: string, newProperties: Tweet) {
    return this._httpClient.patch<Tweet>(this._buildUrl() + tweetId, newProperties.toJSON());
  }

  _buildUrl() {
    return `${environment.BASE_URL}/tweets`;
  }
}
