import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';

class User {
  #name!: string;

  get name() { return this.#name };
  set name(name) { this.#name = name };
}

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {
  private baseUrl = 'http://localhost:3000/api/users/';

  constructor(
    private _httpClient: HttpClient,
    private _toastrService: ToastrService,
    private _router: Router
  ) { }

  get isSignedIn(): User | null {
    const user = localStorage.getItem("auth")
    if (!user) return null
    return JSON.parse(user)
  }

  signIn(username: string, password: string) {
    const url = this.baseUrl + 'signin';
    this._httpClient.post<User>(url, {
      username,
      password
    }).subscribe({
      next: (user) => {
        localStorage.setItem("auth", JSON.stringify(user));
        this._toastrService.success("Success", "Logged in")
        this._router.navigate(["/"]);
      },
      error: (error) => {
        this._toastrService.error(error.error.message)
      }
    })
  }

  signOut() {
    localStorage.removeItem("auth");
  }
}
