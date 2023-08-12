import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ToastrService } from 'ngx-toastr';
import { Router } from '@angular/router';

import { Activity, ActivitiesDataService } from '../activities-data.service';
import { environment } from '../../environments/environment';

@Component({
  selector: 'app-create-activity',
  templateUrl: './create-activity.component.html',
  styleUrls: ['./create-activity.component.css']
})
export class CreateActivityComponent {
  public activityForm!: FormGroup;

  constructor(
    private _formBuilder: FormBuilder,
    private _activitiesDataService: ActivitiesDataService,
    private _toastrService: ToastrService,
    private _router: Router
  ) {
    this.activityForm = this._formBuilder.group({
      name: ['', Validators.required],
      duration: ['', Validators.required],
      description: ['', Validators.required],
    })
  }

  create() {
    const newActivity = new Activity();

    newActivity.name = this.activityForm.value.name;
    newActivity.description = this.activityForm.value.description;
    newActivity.duration = this.activityForm.value.duration;

    this._activitiesDataService.create(newActivity).subscribe({
      next: (createdActivity: Activity) => {
        this._toastrService.success(environment.SUCCESS_MESSAGE)
        this._router.navigate([`/activity/${createdActivity._id}`])
      },
      error: (error) => this._toastrService.error(error.error.message)
    })
  }
}
