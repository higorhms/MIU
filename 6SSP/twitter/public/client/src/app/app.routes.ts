import { HomeComponent } from "./home/home.component";
import { SigninComponent } from "./signin/signin.component";
import { SignupComponent } from "./signup/signup.component";
import { UserInformationComponent } from "./user-information/user-information.component";

export const appRoutes = [{
  path: "",
  component: HomeComponent
},
{
  path: "signin",
  component: SigninComponent
},
{
  path: "signup",
  component: SignupComponent
},
{
  path: "user/:userId",
  component: UserInformationComponent
}
]
