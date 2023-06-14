import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

import { SignUpForm } from './signup/signup.component';

export class User {
  #_id!: string;

  get _id() { return this.#_id };

  set _id(id) { this._id = id };
}

@Injectable({
  providedIn: 'root'
})
export class UsersDataService {

  #baseUrl = "http://localhost:3000/api/users/"

  constructor(
    private _httpClient: HttpClient
  ) { }

  signUp(signUpForm: SignUpForm){
    return this._httpClient.post(this.#baseUrl, signUpForm.toJSON());
  }
}
