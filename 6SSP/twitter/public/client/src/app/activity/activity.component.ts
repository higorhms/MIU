import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { Activity, ActivitiesDataService } from '../activities-data.service';
import { AuthenticationService } from '../authentication.service';

@Component({
  selector: 'app-activity',
  templateUrl: './activity.component.html',
  styleUrls: ['./activity.component.css']
})
export class ActivityComponent implements OnInit {

  public activity: Activity = new Activity();

  constructor(
    private _activatedRoute: ActivatedRoute,
    private _activitiesDataService: ActivitiesDataService,
    private _authenticationService: AuthenticationService
  ) { }

  get isSignedIn() { return this._authenticationService.isSignedIn }

  deleteActivity() {
    this._activitiesDataService.deleteActivity(this.activity._id).subscribe((response) => { console.log(response) });
  }

  ngOnInit(): void {
    const activityId = this._activatedRoute.snapshot.params['activityId'];

    this._activitiesDataService.getActivity(activityId).subscribe({
      next: (activity: Activity) => {
        this.activity = activity;
      }
    })
  }
}
