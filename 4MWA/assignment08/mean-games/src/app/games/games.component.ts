import { Component, OnInit } from '@angular/core';
import { Game, GamesDataService } from '../games-data.service';

@Component({
  selector: 'app-games',
  templateUrl: './games.component.html',
  styleUrls: ['./games.component.css']
})
export class GamesComponent implements OnInit {
  page: number = 0;
  games: Game[] = [];

  constructor(private gamesDataService: GamesDataService) { }

  nextPage(){
    this.page = this.page +1;
    this._getGames(this.page);
  }

  previousPage(){
    if(this.page > 0){
      this.page = this.page -1;
      this._getGames(this.page);
    }
  }

  ngOnInit(): void {
    this._getGames(this.page);
  }

  _getGames(offset: number){
    this.gamesDataService.getGames(offset).subscribe({
      next: (games: Game[]) => {
        this.games = games;
      }
    })
  }
}
