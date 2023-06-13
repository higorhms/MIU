import { Component, OnInit } from '@angular/core';
import { StoriesDataService, Story } from '../stories-data.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-stories',
  templateUrl: './stories.component.html',
  styleUrls: ['./stories.component.css']
})
export class StoriesComponent implements OnInit {
  stories: Story[] = []
  
  constructor(private _storiesDataService : StoriesDataService){}
  
  ngOnInit(): void {
    this._storiesDataService.getStories().subscribe({
      next: (stories: Story[]) =>{
        console.log(stories)
        this.stories = stories;
      }
    })
  }
}
