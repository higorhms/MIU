import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule } from '@angular/router';
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';
import { BrowserAnimationsModule, provideAnimations } from '@angular/platform-browser/animations';
import { ToastrModule, provideToastr } from 'ngx-toastr';
import { JWT_OPTIONS, JwtHelperService } from '@auth0/angular-jwt';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { NavigatorComponent } from './navigator/navigator.component';
import { HomeComponent } from './home/home.component';
import { ActivityComponent } from './activity/activity.component';
import { ActivitiesComponent } from './activities/activities.component';
import { SigninComponent } from './signin/signin.component';
import { SignupComponent } from './signup/signup.component';
import { BenefitComponent } from './benefit/benefit.component';
import { CreateActivityComponent } from './create-activity/create-activity.component';
import { ActivityFieldsInfoComponent } from './activity-fields-info/activity-fields-info.component';
import { UpdateActivityComponent } from './update-activity/update-activity.component';
import { BenefitFieldsInfoComponent } from './benefit-fields-info/benefit-fields-info.component';
import { CreateBenefitComponent } from './create-benefit/create-benefit.component';
import { UpdateBenefitComponent } from './update-benefit/update-benefit.component';
import { appRoutes } from './app.routes';
import { AuthenticationInterceptor } from './authentication.interceptor';

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
    RouterModule.forRoot(appRoutes)
  ],
  providers: [
    provideAnimations(),
    provideToastr(),
    { provide: JWT_OPTIONS, useValue: JWT_OPTIONS },
    JwtHelperService,
    { provide: HTTP_INTERCEPTORS, useClass: AuthenticationInterceptor, multi: true }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
