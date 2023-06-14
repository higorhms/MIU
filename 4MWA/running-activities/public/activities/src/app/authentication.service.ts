import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

class User {
  #name!: string;

  get name() { return this.#name };
  set name(name) { this.#name = name };
}

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {
  private baseUrl = 'http://localhost:3000/users/';

  get isSignedIn(): User | null {
    const user = localStorage.getItem("auth")
    if (!user) return null
    return JSON.parse(user)
  }

  constructor(private httpClient: HttpClient) { }

  signIn(username: string, password: string) {
    const url = this.baseUrl + 'signin';
    const user = this.httpClient.post<User>(url, {
      username,
      password
    })
    localStorage.setItem("auth", JSON.stringify(user));
    return user;
  }
}
