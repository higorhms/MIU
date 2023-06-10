import { Component, OnInit } from '@angular/core';
import { Game, GamesDataService } from '../games-data.service';
import { ActivatedRoute, Router } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-edit-game',
  templateUrl: './edit-game.component.html',
  styleUrls: ['./edit-game.component.css']
})
export class EditGameComponent implements OnInit {
  public game!: Game;
  public gameForm!: FormGroup;

  constructor(
    private gameDataService: GamesDataService,
    private _route: ActivatedRoute,
    private _router: Router,
    private formBuilder: FormBuilder
  ){
    this.gameForm = this.formBuilder.group({
      title: ['', Validators.required],
      price: ['', Validators.required],
      year: ['', Validators.required],
      rate: ['', [Validators.required, Validators.min(0)]],
      minPlayers:['', [Validators.required, Validators.min(1)]],
      maxPlayers: ['', [Validators.required, Validators.min(1)]],
      minAge: ['', [Validators.required, Validators.min(7)]],
    })
  }

  editGame(){
    this.gameDataService.updateGame(this.game._id, this.gameForm.value).subscribe({
      next: (response: any) => {
        this._router.navigate(["/games"]);
        console.log(response);
      }
    });
  }

  ngOnInit(): void {
    const gameId = this._route.snapshot.params['gameId'];

    this.gameDataService.getGame(gameId).subscribe({
      next: (game: Game) => {
        this.game = game;
        this.gameForm.patchValue({
          title: this.game.title,
          price: this.game.price,
          year: this.game.year,
          rate: this.game.rate,
          minPlayers:this.game.minPlayers,
          maxPlayers: this.game.maxPlayers,
          minAge: this.game.minAge,
        })
      }
    })
  }
}
