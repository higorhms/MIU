import { Component, OnInit } from '@angular/core';
import { Activity, ActivitiesDataService } from '../activities-data.service';
import { AuthenticationService } from '../authentication.service';

@Component({
  selector: 'app-activities',
  templateUrl: './activities.component.html',
  styleUrls: ['./activities.component.css']
})
export class ActivitiesComponent implements OnInit {
  public activities: Activity[] = [];
  public page: number = 1;

  constructor(
    private activitiesDataService: ActivitiesDataService,
    private authenticationService: AuthenticationService
  ) { }

  get isSignedIn() { return this.authenticationService.isSignedIn }

  nextPage() {
    if (this.activities.length < 3) return;
    this.page = this.page + 1;
    this._getGames();
  }

  previousPage() {
    if (this.page < 1) return;
    this.page = this.page - 1;
    this._getGames();
  }

  ngOnInit(): void {
    this._getGames();
  }

  _getGames() {
    this.activitiesDataService.getActivities(this.page).subscribe({
      next: (activities: Activity[]) => {
        this.activities = activities;
        console.log(this.activities.length)
      }
    })
  }
}
