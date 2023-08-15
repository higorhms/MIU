import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ToastrService } from 'ngx-toastr';
import { Router } from '@angular/router';

import { SignUpForm } from './signup/signup.component';
import { environment } from '../environments/environment';
import { Authentication, AuthenticationService } from './authentication.service';

export class User {
  #_id!: string;
  #name!: string;
  #username!: string;
  #followers!: String[];

  get _id() { return this.#_id };
  get name() { return this.#name };
  get username() { return this.#username };
  get followers() { return this.#followers };

  set _id(id) { this._id = id };
  set name(name) { this.#name = name };
  set username(username) { this.#username = username };
  set followers(followers) { this.#followers = followers };
}

@Injectable({
  providedIn: 'root'
})
export class UsersDataService {
  private _baseUrl = `${environment.BASE_URL}/users/`;

  constructor(
    private _authenticationService: AuthenticationService,
    private _httpClient: HttpClient,
    private _toastrService: ToastrService,
    private _router: Router
  ) { }

  signIn(username: string, password: string) {
    const url = this._baseUrl + 'signin';
    this._httpClient.post<Authentication>(url, {
      username,
      password
    }).subscribe({
      next: (authentication: Authentication) => {
        this._authenticationService.signIn(authentication.token);
        this._router.navigate(["/"]);
      },
      error: (response) => {
        this._toastrService.error(response.error.message)
      }
    })
  }

  getOne(userId: string){
    return this._httpClient.get<User>(this._baseUrl + userId);
  }

  signUp(signUpForm: SignUpForm) {
    return this._httpClient.post(this._baseUrl, signUpForm.toJSON());
  }

  getAll(username: string, userId: string){
    return this._httpClient.get<User[]>(this._baseUrl, { params: { username, userId } });
  }

  follow(username: string){
    return this._httpClient.post<void>(this._baseUrl + `follow`, {username})
  }

  unfollow(username: string){
    return this._httpClient.post<void>(this._baseUrl + `unfollow`, {username})
  }
}
