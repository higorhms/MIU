import { Component, OnInit } from '@angular/core';
import { Acitivty, ActivitiesDataService } from '../activities-data.service';

@Component({
  selector: 'app-activities',
  templateUrl: './activities.component.html',
  styleUrls: ['./activities.component.css']
})
export class ActivitiesComponent implements OnInit {
  public activities: Acitivty[] = [];

  constructor(private activitiesDataService: ActivitiesDataService){}

  ngOnInit(): void {
    this.activitiesDataService.getActivities().subscribe({
      next: (activities: Acitivty[]) => {
        this.activities = activities;
        console.log(activities)
      }
    })
  }
}
