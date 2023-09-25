import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { Game, GamesDataService } from '../games-data.service';

@Component({
  selector: 'app-game',
  templateUrl: './game.component.html',
  styleUrls: ['./game.component.css']
})
export class GameComponent implements OnInit{
  public game: Game = {} as Game;

  constructor(
    private gameDataService: GamesDataService,
    private _route: ActivatedRoute,
  ){}

  deleteGame(){
    this.gameDataService.deleteGame(this.game._id).subscribe((response: any) => {
      console.log(response)
    });
  }

  ngOnInit(): void {
    const gameId = this._route.snapshot.params['gameId'];

    this.gameDataService.getGame(gameId).subscribe({
      next: (game: Game) => {
        this.game = game;
      }
    })
  }
}
