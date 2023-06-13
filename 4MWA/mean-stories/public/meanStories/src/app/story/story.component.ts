import { Component, OnInit } from '@angular/core';
import { StoriesDataService, Story } from '../stories-data.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-story',
  templateUrl: './story.component.html',
  styleUrls: ['./story.component.css']
})
export class StoryComponent implements OnInit{
  story: Story = new Story();
  storyId!: string;
  
  constructor(private _storiesService: StoriesDataService,
     private _activatedRoute: ActivatedRoute){}

  switchPopularity(){
    let newStatus = "";
    if(this.story.status === "popular"){
      newStatus = "un-popular";
    }else{
      newStatus = "popular";
    }
    
    this._storiesService.switchPopularity(this.storyId, newStatus).subscribe({
      next: (updatedStory:Story) => {
        this.story = updatedStory;
      }
    })
  }

  ngOnInit(): void {
    this.storyId = this._activatedRoute.snapshot.params["storyId"]
    this._getStory(this.storyId);
  }
  
  _getStory(storyId: string){
    this._storiesService.getStory(this.storyId).subscribe({
      next: (story: Story) => {
        this.story = story;
      }
    })
  }
}
