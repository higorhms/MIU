import { Injectable } from '@angular/core';
import { JwtHelperService } from '@auth0/angular-jwt';

import { environment } from '../environments/environment';

export class Authentication {
  #token!: string;
  get token() { return this.#token };
  set token(token) { this.#token = token };
}

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {
  constructor(
    private _jwt: JwtHelperService
  ) { }

  get isSignedIn(): boolean {
    return !!this.token;
  }

  get name(): string {
    return this._jwt.decodeToken(this.token)?.name;
  }

  get token(): string{
    return localStorage.getItem(environment.AUTH_KEY) as string;
  }

  signIn(token: string) {
    localStorage.setItem(environment.AUTH_KEY, token);
  }

  signOut() {
    localStorage.clear();
  }
}
