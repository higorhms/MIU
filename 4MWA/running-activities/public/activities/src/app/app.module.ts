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
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BenefitComponent } from './benefit/benefit.component';
import { CreateActivityComponent } from './create-activity/create-activity.component';
import { ActivityFieldsInfoComponent } from './activity-fields-info/activity-fields-info.component';
import { UpdateActivityComponent } from './update-activity/update-activity.component';
import { BenefitFieldsInfoComponent } from './benefit-fields-info/benefit-fields-info.component';
import { CreateBenefitComponent } from './create-benefit/create-benefit.component';
import { UpdateBenefitComponent } from './update-benefit/update-benefit.component';

@NgModule({
  declarations: [
    AppComponent,
    NavigatorComponent,
    HomeComponent,
    ActivityComponent,
    ActivitiesComponent,
    SigninComponent,
    SignupComponent,
    BenefitComponent,
    CreateActivityComponent,
    ActivityFieldsInfoComponent,
    UpdateActivityComponent,
    BenefitFieldsInfoComponent,
    CreateBenefitComponent,
    UpdateBenefitComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    ToastrModule.forRoot(),
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
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
      path: "activities/create",
      component: CreateActivityComponent
    },
    {
      path: "activities/update/:activityId",
      component: UpdateActivityComponent
    },
    {
      path: "activities/create/:activityId/benefit",
      component: CreateBenefitComponent
    },
    {
      path: "activity/:activityId/benefit/:benefitId",
      component: BenefitComponent
    },
    {
      path: "activity/:activityId/update/benefit/:benefitId",
      component: BenefitComponent
    },
    {
      path: "activities/:activityId/update/benefit/:benefitId",
      component: UpdateBenefitComponent
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
