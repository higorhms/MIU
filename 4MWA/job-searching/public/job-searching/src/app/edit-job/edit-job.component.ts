import { Component, OnInit } from '@angular/core';
import { Job, JobsdataService } from '../jobsdata.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-edit-job',
  templateUrl: './edit-job.component.html',
  styleUrls: ['./edit-job.component.css']
})
export class EditJobComponent implements OnInit{

  jobId!: string;
  form: Partial<Job> = new Job();

  constructor(private _jobsDataService: JobsdataService,
    private _router: ActivatedRoute,
    private _route: Router){}

  submitForm(){
    this._jobsDataService.update(this.jobId, this.form).subscribe({
      next: (job) => {
        console.log(job)
        this._route.navigate(["/jobs"])
      }
    })
  }

  ngOnInit(): void {
    this.jobId = this._router.snapshot.params["jobId"];
    this._jobsDataService.getJob(this.jobId).subscribe({
      next: (job: Job)=>{
        this.form = job;
      }
    })
  }
}
