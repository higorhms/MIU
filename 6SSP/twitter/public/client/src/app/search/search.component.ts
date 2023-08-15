import { Component, Input, OnInit } from '@angular/core';
import { User, UsersDataService } from '../users-data.service';
import { AuthenticationService } from '../authentication.service';

export class SearchForm {
  #username: string = '';
  get username() { return this.#username }
  set username(username) { this.#username = username }
}

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {
  public users: User[] = [];
  public form: SearchForm = new SearchForm();

  get id() { return this._authenticationService.id }
  get isSignedIn() { return this._authenticationService.isSignedIn }
  @Input() title: string = '';
  @Input() user: User = new User();

  constructor(
    private _usersDataService: UsersDataService,
    private _authenticationService: AuthenticationService,
  ) { }

  _getUsers() {
    this._usersDataService.getAll(this.form.username, this.user._id).subscribe({
      next: (users: User[]) => {
        if (this.user._id && this.title === 'Following') this.users = this._filterFollowing(this.user, users);
        if (this.user._id && this.title === 'Followers') this.users = this._filterFollowers(this.user, users);
        if (this.title === 'Who to follow') this.users = this.users = users;
      }
    })
  }

  onSearchChange() {
    this._getUsers();
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
    if (user.followers.includes(this.id))
      return this.unfollow(user.username);
    return this.follow(user.username);
  }

  followAction(user: User): string {
    if (user.followers.includes(this.id))
      return 'Unfollow';
    return 'Follow';
  }

  _filterFollowing(user: User, users: User[]): User[] {
    const usersToReturn = users.filter(returnedUser => {
      return returnedUser.followers.includes(user._id)
    })
    return usersToReturn;
  }

  _filterFollowers(user: User, users: User[]): User[] {
    const usersToReturn = users.filter(returnedUser => {
      return user?.followers.includes(returnedUser._id)
    })
    return usersToReturn;
  }

  ngOnInit(): void {
    this._getUsers();
  }
}
