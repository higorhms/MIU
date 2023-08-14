import { Component, OnInit } from '@angular/core';
import { ToastrService } from 'ngx-toastr';

import { AuthenticationService } from '../authentication.service';
import { environment } from '../../environments/environment';
import { TweetsDataService, Tweet } from '../tweets-data.service';

class CreatePostForm{
  #description!: string;
  get description() { return this.#description }
  set description(description) { this.#description = description }

  toJSON() {
    return {
      description: this.description,
    }
  }
}

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  public tweets: Tweet[] = [];
  public page: number = environment.DEFAULT_FIRST_PAGE;
  public form: CreatePostForm = new CreatePostForm();

  constructor(
    private _authenticationService: AuthenticationService,
    private _tweetsDataService: TweetsDataService,
    private _toastrService: ToastrService,
  ) { }

  get isSignedIn() { return this._authenticationService.isSignedIn }

  nextPage() {
    if (this.tweets.length < environment.DEFAULT_AMOUNT_OF_RESULTS) return;
    this.page = this.page + environment.PAGE_SKIPPER;
    this._getTweets();
  }

  previousPage() {
    if (this.page < environment.PAGE_SKIPPER) return;
    this.page = this.page - environment.PAGE_SKIPPER;
    this._getTweets();
  }

  ngOnInit(): void {
    this._getTweets();
  }

  _getTweets() {
    this._tweetsDataService.getAll().subscribe({
      next: (tweets: Tweet[]) => {
        this.tweets = tweets;
      }
    })
  }

  _create() {
    this._tweetsDataService.create(this.form.description).subscribe({
      next: () => {
        this._toastrService.success(environment.SUCCESS_MESSAGE);
        this._getTweets()
      },
      error: (error) => this._toastrService.error(error.error.message)
    })
  }
}
