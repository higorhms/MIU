import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from 'rxjs';

export class Game {
  #_id!: string;
  #title!: string;
  #year!: string;
  #rate!: number;
  #price!: number;
  #minPlayers!: number;
  #maxPlayers!: number;
  #minAge!: number;
  get _id() { return this.#_id; }
  get title() { return this.#title; }
  set title(title: string) { this.#title = title; }
  get year() { return this.#year; }
  get rate() { return this.#rate; }
  get price() { return this.#price; }
  set price(price: number) { this.#price = price; }
  get minPlayers() { return this.#minPlayers; }
  get maxPlayers() { return this.#maxPlayers; }
  get minAge() { return this.#minAge; }
  set minAge(minAge) {this.#minAge = minAge}
  set year(year) {this.#year = year}
  set rate(rate) {this.#rate = rate}
  set maxPlayers(maxPlayers) {this.#maxPlayers = maxPlayers}
  set minPlayers(minPlayers) {this.#minPlayers = minPlayers}
  constructor(id: string, title: string, price: number) {
    this.#_id = id;
    this.#title = title;
    this.#price = price;
  }
}

@Injectable({
  providedIn: 'root'
})
export class GamesDataService {

  _baseUrl: string = "http://localhost:3000/api/games";

  constructor(private httpClient: HttpClient) { }

  getGames(offset: number, count?: number): Observable<Game[]>{
    if(offset || count) return this.httpClient.get<Game[]>(this._baseUrl, {params: {
      offset,
      count: count || 10
    }});
    return this.httpClient.get<Game[]>(this._baseUrl);
  }

  getGame(gameId: string): Observable<Game>{
    return this.httpClient.get<Game>(this._baseUrl + "/" + gameId)
  }

  deleteGame(gameId: string){
    return this.httpClient.delete(this._baseUrl + "/" + gameId);
  }

  updateGame(gameId: string, updatedGame: Partial<Game>){
    return this.httpClient.patch(this._baseUrl + `/${gameId}`, updatedGame);
  }

  createGame(game: Partial<Game>){
    return this.httpClient.post(this._baseUrl, {
      title: game.title,
      year: game.year,
      rate: game.rate,
      price: game.price,
      minPlayers: game.minPlayers,
      maxPlayers: game.maxPlayers,
      minAge: game.minAge,
    })
  }
}
