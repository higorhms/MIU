import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivitiesDataService, Activity } from '../activities-data.service';
import { ToastrService } from 'ngx-toastr';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-update-activity',
  templateUrl: './update-activity.component.html',
  styleUrls: ['./update-activity.component.css']
})
export class UpdateActivityComponent implements OnInit {
  public activityForm!: FormGroup;
  public activity: Activity = new Activity();

  constructor(
    private formBuilder: FormBuilder,
    private activitiesDataService: ActivitiesDataService,
    private toastrService: ToastrService,
    private router: Router,
    private activatedRoute: ActivatedRoute
  ) {
    this.activityForm = this.formBuilder.group({
      name: ['', Validators.required],
      duration: ['', Validators.required],
      description: ['', Validators.required],
    })
  }

  ngOnInit(): void {
    const activityId = this.activatedRoute.snapshot.params['activityId'];

    this.activitiesDataService.getActivity(activityId).subscribe({
      next: (activity: Activity) => {
        this.activity = activity;
        this.activityForm = this.formBuilder.group({
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
    this.activitiesDataService.create(newActivity).subscribe({
      next: (createdActivity: Activity) => {
        this.toastrService.success("Activity created!")
        this.router.navigate([`/activity/${createdActivity._id}`])
      },
      error: (error) => {
        this.toastrService.error(error.error.message);
      }
    })
  }

}
