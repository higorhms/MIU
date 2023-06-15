import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';
import { BrowserAnimationsModule, provideAnimations } from '@angular/platform-browser/animations';
import { ToastrModule, provideToastr } from 'ngx-toastr';

import { AppComponent } from './app.component';
import { NavigatorComponent } from './navigator/navigator.component';
import { HomeComponent } from './home/home.component';
import { ActivityComponent } from './activity/activity.component';
import { ActivitiesComponent } from './activities/activities.component';
import { SigninComponent } from './signin/signin.component';
import { SignupComponent } from './signup/signup.component';
import { FormsModule } from '@angular/forms';
import { BenefitComponent } from './benefit/benefit.component';

@NgModule({
  declarations: [
    AppComponent,
    NavigatorComponent,
    HomeComponent,
    ActivityComponent,
    ActivitiesComponent,
    SigninComponent,
    SignupComponent,
    BenefitComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    ToastrModule.forRoot(),
    HttpClientModule,
    FormsModule,
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
      path: "activity/:activityId/benefit/:benefitId",
      component: BenefitComponent
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
  providers: [
    provideAnimations(),
    provideToastr(),
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
