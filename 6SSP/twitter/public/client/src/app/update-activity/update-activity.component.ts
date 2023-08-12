import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ToastrService } from 'ngx-toastr';
import { ActivatedRoute, Router } from '@angular/router';

import { environment } from '../../environments/environment';
import { ActivitiesDataService, Activity } from '../activities-data.service';

@Component({
  selector: 'app-update-activity',
  templateUrl: './update-activity.component.html',
  styleUrls: ['./update-activity.component.css']
})
export class UpdateActivityComponent implements OnInit {
  public activityForm!: FormGroup;
  public activity: Activity = new Activity();

  constructor(
    private _formBuilder: FormBuilder,
    private _activitiesDataService: ActivitiesDataService,
    private _toastrService: ToastrService,
    private _router: Router,
    private _activatedRoute: ActivatedRoute
  ) {
    this.activityForm = this._formBuilder.group({
      name: ['', Validators.required],
      duration: ['', Validators.required],
      description: ['', Validators.required],
    })
  }

  ngOnInit(): void {
    const activityId = this._activatedRoute.snapshot.params['activityId'];

    this._activitiesDataService.getActivity(activityId).subscribe({
      next: (activity: Activity) => {
        this.activity = activity;
        this.activityForm = this._formBuilder.group({
          name: [activity.name, Validators.required],
          duration: [activity.duration, Validators.required],
          description: [activity.description, Validators.required],
        })
      }
    })
  }

  update() {
    const newActivity = new Activity();
    newActivity.name = this.activityForm.value.name;
    newActivity.description = this.activityForm.value.description;
    newActivity.duration = this.activityForm.value.duration;
    this._activitiesDataService.create(newActivity).subscribe({
      next: (createdActivity: Activity) => {
        this._toastrService.success(environment.SUCCESS_MESSAGE)
        this._router.navigate([`/activity/${createdActivity._id}`])
      },
      error: (error) => {
        this._toastrService.error(error.error.message);
      }
    })
  }

}
