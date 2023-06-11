import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { JobComponent } from './job/job.component';
import { JobsComponent } from './jobs/jobs.component';
import { RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { ErrorComponent } from './error/error.component';
import { NavigatorComponent } from './navigator/navigator.component';
import { HttpClientModule } from '@angular/common/http';
import { EditJobComponent } from './edit-job/edit-job.component';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    JobComponent,
    JobsComponent,
    HomeComponent,
    ErrorComponent,
    NavigatorComponent,
    EditJobComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    RouterModule.forRoot([{
      path: "jobs",
      component: JobsComponent
    },
    {
      path: "job/:jobId",
      component: JobComponent
    },
    {
      path: "job/:jobId/edit",
      component: EditJobComponent
    },
    {
      path: "",
      component: HomeComponent
    },
    // {
    //   path: "**",
    //   component: ErrorComponent
    // }
  ])
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
