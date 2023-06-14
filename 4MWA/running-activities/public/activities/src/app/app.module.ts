import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule } from '@angular/router';

import { AppComponent } from './app.component';
import { NavigatorComponent } from './navigator/navigator.component';
import { HomeComponent } from './home/home.component';
import { ActivityComponent } from './activity/activity.component';
import { ActivitiesComponent } from './activities/activities.component';
import { FooterComponent } from './footer/footer.component';
import { HttpClientModule } from '@angular/common/http';
import { SigninComponent } from './signin/signin.component';
import { SignupComponent } from './signup/signup.component';

@NgModule({
  declarations: [
    AppComponent,
    NavigatorComponent,
    HomeComponent,
    ActivityComponent,
    ActivitiesComponent,
    FooterComponent,
    SigninComponent,
    SignupComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    RouterModule.forRoot([{
      path: "",
      component: HomeComponent
    },
    {
      path: "activities",
      component: ActivitiesComponent
    },
    {
      path: "activity/:activityId",
      component: ActivityComponent
    },
    {
      path: "signin",
      component: SigninComponent
    },
    {
      path: "signup",
      component: SignupComponent
    }
  ])
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
