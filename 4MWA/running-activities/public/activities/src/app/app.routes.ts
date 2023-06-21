import { ActivitiesComponent } from "./activities/activities.component";
import { ActivityComponent } from "./activity/activity.component";
import { BenefitComponent } from "./benefit/benefit.component";
import { CreateActivityComponent } from "./create-activity/create-activity.component";
import { CreateBenefitComponent } from "./create-benefit/create-benefit.component";
import { HomeComponent } from "./home/home.component";
import { SigninComponent } from "./signin/signin.component";
import { SignupComponent } from "./signup/signup.component";
import { UpdateActivityComponent } from "./update-activity/update-activity.component";
import { UpdateBenefitComponent } from "./update-benefit/update-benefit.component";

export const appRoutes = [{
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
]
