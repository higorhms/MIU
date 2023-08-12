import { Component } from '@angular/core';

import { UsersDataService } from '../users-data.service';

export class SignInForm {
  #username!: string;
  #password!: string;

  get username() { return this.#username }
  get password() { return this.#password }

  set username(username) { this.#username = username }
  set password(password) { this.#password = password }

  toJSON() {
    return {
      username: this.username,
      password: this.password,
    }
  }
}

@Component({
  selector: 'app-signin',
  templateUrl: './signin.component.html',
  styleUrls: ['./signin.component.css']
})
export class SigninComponent {

  public form: SignInForm = new SignInForm();

  constructor(
    private _usersDataService: UsersDataService,
  ) { }

  signIn() {
    this._usersDataService.signIn(this.form.username, this.form.password);
  }
}
