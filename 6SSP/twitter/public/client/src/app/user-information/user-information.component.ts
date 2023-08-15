import { Component, OnInit } from '@angular/core';
import { User, UsersDataService } from '../users-data.service';
import { ActivatedRoute } from '@angular/router';
import { AuthenticationService } from '../authentication.service';

@Component({
  selector: 'app-user-information',
  templateUrl: './user-information.component.html',
  styleUrls: ['./user-information.component.css']
})
export class UserInformationComponent implements OnInit  {
    public user: any = null;

    constructor(
      private _activatedRoute: ActivatedRoute,
      private _usersDataService: UsersDataService,
      private _authenticationService: AuthenticationService
    ) { }

    get isSignedIn() { return this._authenticationService.isSignedIn }

    ngOnInit(): void {
      const userId = this._activatedRoute.snapshot.params['userId'];

      this._usersDataService.getOne(userId).subscribe({
        next: (user: User) => {
          this.user = user;
        }
      })
    }
}
