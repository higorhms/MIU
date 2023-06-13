import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { StoriesComponent } from './stories/stories.component';
import { StoryComponent } from './story/story.component';
import { NavigatorComponent } from './navigator/navigator.component';
import { RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    StoriesComponent,
    StoryComponent,
    NavigatorComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    RouterModule.forRoot([{
      path: "",
      component: HomeComponent
    },
    {
      path: "stories",
      component: StoriesComponent
    },
    {
      path: "stories/:storyId",
      component: StoryComponent
    }
  ])
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
