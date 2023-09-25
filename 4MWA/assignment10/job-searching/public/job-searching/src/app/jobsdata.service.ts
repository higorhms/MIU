import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";

export class Job {
  _id!: string;
  title!: string;
  salary!: string;
  description!: string;
  experience!: string;
  skills!: [string];
  postDate!: Date;

  constructor() { }
}

@Injectable({
  providedIn: 'root'
})
export class JobsdataService {

  private _baseUrl = "http://localhost:3000/api/jobs/"

  constructor(private _httpClient: HttpClient) { }


  getJobs(offset: number, count: number) {
    return this._httpClient.get<Job[]>(this._baseUrl, {
      params: {
        offset,
        count: count
      }
    });
  }

  getJob(jobId: string){
    return this._httpClient.get<Job>(this._baseUrl + jobId);
  }

  update(jobId: string, job: Partial<Job>){
    return this._httpClient.patch<Job>(this._baseUrl + jobId, job);
  }

  delete(jobId: string){
    return this._httpClient.delete(this._baseUrl + jobId);
  }
}
