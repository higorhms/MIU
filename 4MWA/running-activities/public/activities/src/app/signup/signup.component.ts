import { Component } from '@angular/core';
import { UsersDataService } from '../users-data.service';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
export class SignUpForm {
  #name!: string;
  #username!: string;
  #password!: string;
  #repeatPassword!: string;

  get name() { return this.#name }
  get username() { return this.#username }
  get password() { return this.#password }
  get repeatPassword() { return this.#repeatPassword }

  set name(name) { this.#name = name }
  set username(username) { this.#username = username }
  set password(password) { this.#password = password }
  set repeatPassword(repeatPassword) { this.#repeatPassword = repeatPassword }

  toJSON() {
    return {
      name: this.name,
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

  constructor(
    private _usersDataService: UsersDataService,
    private _router: Router,
    private toastr: ToastrService
  ) { }

  signUp() {
    this._usersDataService.signUp(this.form).subscribe({
      next: () => {
        this.toastr.success('Success', "Signed up succesfully");
      },
      error: (error) => {
        console.log(error)
        this.toastr.error('Failed', error.error.message);
      },
      complete: () => {
        this._router.navigate(["/"]);
      }
    })
  }
}
