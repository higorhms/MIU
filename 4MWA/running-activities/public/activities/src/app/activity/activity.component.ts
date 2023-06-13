import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { Acitivty, ActivitiesDataService } from '../activities-data.service';

@Component({
  selector: 'app-activity',
  templateUrl: './activity.component.html',
  styleUrls: ['./activity.component.css']
})
export class ActivityComponent implements OnInit {

  public activity: Acitivty = {} as Acitivty;

  constructor(
    private _route: ActivatedRoute,
    private activitiesDataService: ActivitiesDataService
  ) { }


  deleteActivity() {
    this.activitiesDataService.deleteActivity(this.activity._id).subscribe((response) => {console.log(response)});
  }

  ngOnInit(): void {
    const activityId = this._route.snapshot.params['activityId'];

    this.activitiesDataService.getActivity(activityId).subscribe({
      next: (activity: Acitivty) => {
        this.activity = activity;
      }
    })
  }
}
