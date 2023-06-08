import { Component, OnInit } from '@angular/core';
import { Game, GamesDataService } from '../games-data.service';

@Component({
  selector: 'app-games',
  templateUrl: './games.component.html',
  styleUrls: ['./games.component.css']
})
export class GamesComponent implements OnInit {
  games: Game[] = [];

  constructor(private gamesDataService: GamesDataService) { }


  ngOnInit(): void {
    this.gamesDataService.getGames().subscribe({
      next: (games: Game[]) => {
        this.games = games;
      }
    })
  }
}
