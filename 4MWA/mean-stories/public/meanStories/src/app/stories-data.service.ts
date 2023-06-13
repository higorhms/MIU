import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";

export class Story {
  _id!: String;
  title!: String;
  container: {
    name: String;
    short_name: String;
  } = {name: "", short_name: ""};
  topic: {
    name: String;
    short_name: String;
  } = { name: "", short_name: ""};
  user: {
    name: String
  } = { name: ""};
  status!: String;
  description!: String;
  comments!: Number;
  media!: String;
}

@Injectable({
  providedIn: 'root'
})
export class StoriesDataService {

  baseUrl = "http://localhost:3000/api/stories/"

  constructor(private _httpClient: HttpClient) { }

  getStories(offset: number = 1, count: number = 10){
    console.log("called")
    return this._httpClient.get<Story[]>(this.baseUrl);
  }

  getStory(storyId: string){
    return this._httpClient.get<Story>(this.baseUrl + storyId);
  }

  switchPopularity(storyId: string, status: string){
    console.log(storyId, status)
    return this._httpClient.patch<Story>(this.baseUrl + storyId, {
      status: status
    })
  }
}
