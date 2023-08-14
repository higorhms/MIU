import { Component, OnInit } from '@angular/core';
import { User, UsersDataService } from '../users-data.service';
import { AuthenticationService } from '../authentication.service';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  public users: User[] = [];

  id() { return this._authenticationService.id }

  constructor(
    private _usersDataService: UsersDataService,
    private _authenticationService: AuthenticationService,
  ) { }

  _getUsers() {
    this._usersDataService.getAll().subscribe({
      next: (users: User[]) => {
        this.users = users;
        console.log(this.users);
      }
    })
  }

  follow(username: string) {
    this._usersDataService.follow(username).subscribe({
      next: () => this._getUsers()
    })
  }

  unfollow(username: string) {
    this._usersDataService.unfollow(username).subscribe({
      next: () => this._getUsers()
    })
  }

  toggleFollow(user: User): void {
    if (user.followers.includes(this.id()))
      return this.unfollow(user.username);
    return this.follow(user.username);
  }

  followAction(user: User): string {
    if (user.followers.includes(this.id()))
      return 'Unfollow';
    return 'Follow';
  }

  ngOnInit(): void {
    this._getUsers();
  }
}
