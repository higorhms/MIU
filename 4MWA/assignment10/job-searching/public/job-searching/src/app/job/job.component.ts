import { Component, OnInit } from '@angular/core';
import { Job, JobsdataService } from '../jobsdata.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-job',
  templateUrl: './job.component.html',
  styleUrls: ['./job.component.css']
})
export class JobComponent implements OnInit{
  job: Job = new Job();
  
  constructor(
    private _jobsDataService: JobsdataService,
    private _router: ActivatedRoute,
    private _route: Router
    ){}

  deleteJob(){
    this._jobsDataService.delete(this.job._id).subscribe({
      next: (result: any)=>{
        console.log(result);
        this._route.navigate(["/jobs"]);
      }
    })
  }
  
  ngOnInit(): void {
    const jobId = this._router.snapshot.params["jobId"];
    this._jobsDataService.getJob(jobId).subscribe({
      next: (job: Job) => {
        console.log(job);
        this.job = job;
      }
    })
  }
  
}
