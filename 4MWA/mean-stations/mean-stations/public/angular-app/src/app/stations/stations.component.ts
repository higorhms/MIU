import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { StationsDataService } from '../stations-data.service';

export class Station {
  #_id!: string;
  #st!: string;
  #ts!: Date;
  #airTemperature!: Number;
  #dewPoint!: Number;
  #pressure!: Number;
  #visibility!: Number;
  #precipitationEstimatedObservation!: Number;
  #wind: {
    direction: Number,
    speed: Number,
  } = { direction: 0, speed: 0}
  #position: {
    coordinates: Number[];
  } = { coordinates: []}

  get _id() {return this.#_id;};
  get st() {return this.#st;};
  get ts() {return this.#ts;}
  get airTemperature() {return this.#airTemperature;}
  get dewPoint() {return this.#dewPoint;}
  get pressure() {return this.#pressure;}
  get visibility() {return this.#visibility;}
  get precipitationEstimatedObservation() {return this.#precipitationEstimatedObservation;}
  get wind(){return this.#wind}
  get position(){return this.#position}

  set _id(_id) {this.#_id= _id;}
  set st(st) {this.#st= st;}
  set ts(ts) {this.#ts= ts;}
  set airTemperature(airTemperature) {this.#airTemperature= airTemperature;}
  set dewPoint(dewPoint) {this.#dewPoint= dewPoint;}
  set pressure(pressure) {this.#pressure= pressure;}
  set visibility(visibility) {this.#visibility= visibility;}
  set precipitationEstimatedObservation(precipitationEstimatedObservation) {this.#precipitationEstimatedObservation= precipitationEstimatedObservation;}
  set wind(wind){this.#wind = wind}
  set position(position){this.#position = position}

  constructor() {
  }
}

@Component({
  selector: 'app-stations',
  templateUrl: './stations.component.html',
  styleUrls: ['./stations.component.css']
})
export class StationsComponent implements OnInit {
  page: number = 1;
  stations!: Station[];
  stationsToDelete: string[] = [];

  constructor(private stationService:StationsDataService, private _router:Router) { }

  ngOnInit(): void {
    this.getStations(this.page);
  }

  private getStations(offset: number) {
    this.stationService.getStations(offset).subscribe({ 
      next: (stations)=> this.fillStations(stations),
      error: (error)=>{this.stations= []; console.log(error);
      },
    });
  }

  private fillStations(stations: Station[]) {
    this.stations= stations;
  }

  toogleStationToDeleteList(id: string){
    const includes = this.stationsToDelete.includes(id)
    if(includes){
      this.stationsToDelete = this.stationsToDelete.filter(deleteId => deleteId !== id);
    }else{
      this.stationsToDelete.push(id);
    }
    console.log(this.stationsToDelete)
  }

  onDelete(){
    this.stationService.deleteMany(this.stationsToDelete).subscribe({
      next: () => {
        this.getStations(this.page);
      }
    })
  }

  nextPage(){
    this.page = this.page + 1;
    this.getStations(this.page);
  }

  previousPage(){
    if(this.page > 1){
      this.page = this.page - 1;
      this.getStations(this.page);
    }
  }
}
