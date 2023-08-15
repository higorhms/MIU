import { Component } from '@angular/core';

import { AuthenticationService } from '../authentication.service';

@Component({
  selector: 'app-navigator',
  templateUrl: './navigator.component.html',
  styleUrls: ['./navigator.component.css']
})
export class NavigatorComponent {
  constructor(
    private _authenticationService: AuthenticationService
  ) { }

  get isSignedIn() { return this._authenticationService.isSignedIn }

  get id() { return this._authenticationService.id }

  signOut() { return this._authenticationService.signOut() }
}
