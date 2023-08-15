import { Component, OnInit, HostListener } from '@angular/core';
import { ToastrService } from 'ngx-toastr';

import { AuthenticationService } from '../authentication.service';
import { environment } from '../../environments/environment';
import { TweetsDataService, Tweet } from '../tweets-data.service';

class CreatePostForm {
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
  }

  ngOnInit(): void {
    this._getTweets();
  }

  _getTweets(newTweet: boolean = false) {
    if (newTweet) this.page = environment.DEFAULT_FIRST_PAGE;
    this._tweetsDataService.getAll(this.page).subscribe({
      next: (tweets: Tweet[]) => {
        if (newTweet) this.tweets = tweets;
        if (!newTweet) this.tweets = [...this.tweets, ...tweets];
        this.nextPage();
      }
    })
  }

  _create() {
    this._tweetsDataService.create(this.form.description).subscribe({
      next: () => this._getTweets(true),
      error: (error) => this._toastrService.error(error.error.message)
    })
  }

  @HostListener('window:scroll', ['$event'])
  onScroll() {
    const pos = (document.documentElement.scrollTop || document.body.scrollTop) + document.documentElement.offsetHeight;
    const max = document.documentElement.scrollHeight;
    if (pos >= max) this._getTweets();
  }
}
