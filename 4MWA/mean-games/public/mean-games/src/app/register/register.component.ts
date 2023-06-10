import { Component } from '@angular/core';
import { Game, GamesDataService } from '../games-data.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {
  form: Partial<Game> = {};

  constructor(
    private gameDataSerice: GamesDataService,
    private _route: Router
  ) { }

  onSubmit() {
    console.log(this.form)
    this.gameDataSerice.createGame(this.form)
    .subscribe({
      next: (response) => {
        console.log(response);
        this._route.navigate(['/games'])
      },
      error: (error) => {console.log(error)}
    });
  }
}
