import { Component, OnInit } from '@angular/core';
import { Job, JobsdataService } from '../jobsdata.service';

@Component({
  selector: 'app-jobs',
  templateUrl: './jobs.component.html',
  styleUrls: ['./jobs.component.css']
})
export class JobsComponent implements OnInit{

  page: number = 1;
  jobs: Job[] = [];

  constructor(private _jobsDataService: JobsdataService){}
  
  previousPage(){
    if(this.page > 1){
      this.page = this.page - 1;
      this._getGames(this.page);
    }    
  }

  nextPage(){
    console.log(this.page);
    this.page = this.page + 1;
    this._getGames(this.page);
  }

  ngOnInit(): void {
    this._getGames(this.page, 15);
  }

  _getGames(offset: number, count: number = 15){
    this._jobsDataService.getJobs(offset, count).subscribe({
      next: (jobs: Job[]) => {
        console.log(jobs)
        this.jobs = jobs;
      }
    })
  }
}
