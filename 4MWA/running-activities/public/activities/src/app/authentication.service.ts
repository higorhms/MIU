import { Injectable } from '@angular/core';
import { JwtHelperService } from '@auth0/angular-jwt';

class User {
  #name!: string;

  get name() { return this.#name };
  set name(name) { this.#name = name };
}

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {
  constructor(
    private _jwt: JwtHelperService
  ) { }

  get isSignedIn(): string {
    return localStorage.getItem("auth") as string;
  }

  get name(): string {
    return this._jwt.decodeToken(this.isSignedIn).name;
  }

  signIn(token: string) {
    localStorage.setItem("auth", token);
  }

  signOut() {
    localStorage.removeItem("auth");
  }
}
