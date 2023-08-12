import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ToastrService } from 'ngx-toastr';
import { Router } from '@angular/router';

import { SignUpForm } from './signup/signup.component';
import { environment } from '../environments/environment';
import { Authentication, AuthenticationService } from './authentication.service';

export class User {
  #_id!: string;

  get _id() { return this.#_id };

  set _id(id) { this._id = id };
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
        this._toastrService.success(environment.WELCOME_MESSAGE + this._authenticationService.name)
        this._router.navigate(["/"]);
      },
      error: (response) => {
        this._toastrService.error(response.error.message)
      }
    })
  }

  signUp(signUpForm: SignUpForm) {
    return this._httpClient.post(this._baseUrl, signUpForm.toJSON());
  }
}
