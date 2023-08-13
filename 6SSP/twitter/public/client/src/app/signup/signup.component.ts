import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';

import { environment } from '../../environments/environment';
import { UsersDataService } from '../users-data.service';

export class SignUpForm {
  #username!: string;
  #password!: string;
  #repeatPassword!: string;

  get username() { return this.#username }
  get password() { return this.#password }
  get repeatPassword() { return this.#repeatPassword }

  set username(username) { this.#username = username }
  set password(password) { this.#password = password }
  set repeatPassword(repeatPassword) { this.#repeatPassword = repeatPassword }

  toJSON() {
    return {
      username: this.username,
      password: this.password,
      repeatPassword: this.repeatPassword,
    }
  }
}

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent {
  public form: SignUpForm = new SignUpForm();
  public passwordsMatch: boolean = true;

  constructor(
    private _usersDataService: UsersDataService,
    private _router: Router,
    private _toastrService: ToastrService
  ) { }

  signUp() {
    this._usersDataService.signUp(this.form).subscribe({
      next: () => {
        this._toastrService.success(environment.SUCCESS_MESSAGE);
        this._router.navigate(["/signin"]);
      },
      error: (error) => this._toastrService.error(error.error.message),
    })
  }

  validatePasswords() {
    this.passwordsMatch = this.form.password === this.form.repeatPassword;
  }
}
