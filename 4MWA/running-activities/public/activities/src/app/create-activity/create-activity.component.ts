import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Activity, ActivitiesDataService } from '../activities-data.service';
import { ToastrService } from 'ngx-toastr';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-activity',
  templateUrl: './create-activity.component.html',
  styleUrls: ['./create-activity.component.css']
})
export class CreateActivityComponent {
  public activityForm!: FormGroup;

  constructor(
    private formBuilder: FormBuilder,
    private _activitiesDataService: ActivitiesDataService,
    private _toastrService: ToastrService,
    private router: Router
  ) {
    this.activityForm = this.formBuilder.group({
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
        this._toastrService.success("Activity created!")
        this.router.navigate([`/activity/${createdActivity._id}`])
      },
      error: (error) => {
        this._toastrService.error(error.error.message);
      }
    })
  }
}
