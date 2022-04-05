import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { JobDetailComponent } from './job-detail/job-detail.component';
import { JobApplyComponent } from './job-apply/job-apply.component';
import { JobPostingComponent } from './job-posting/job-posting.component';
import { NavBarComponent } from './nav-bar/nav-bar.component';
import { SalaryTrendLabComponent } from './salary-trend-lab/salary-trend-lab.component';
import { SkillsTrendLabComponent } from './skills-trend-lab/skills-trend-lab.component';
import { TrendLabComponent } from './trend-lab/trend-lab.component';
import { ChatbotComponent } from './chatbot/chatbot.component';
import { CvGenerationComponent } from './cv-generation/cv-generation.component';
import { LearningPortalComponent } from './learning-portal/learning-portal.component';
import { AssesmentPortalComponent } from './assesment-portal/assesment-portal.component';
import { JobSeekerRegisterComponent } from './job-seeker-register/job-seeker-register.component';
import { RecruiterRegisterComponent } from './recruiter-register/recruiter-register.component';
import { LoginComponent } from './login/login.component';
import { AssesmentTestPortalComponent } from './assesment-test-portal/assesment-test-portal.component';

import { RegisterComponent } from './register/register.component';
import { SkilltestComponent } from './skilltest/skilltest.component';
import { UpdateDetailsComponent } from './update-details/update-details.component';
import { UpdateUserDetailsComponent } from './update-user-details/update-user-details.component';


const routes: Routes = [
  {path: 'trend',component: TrendLabComponent},
  {path: 'skills',component: SkillsTrendLabComponent},
  {path : 'salary',component: SalaryTrendLabComponent},
  {path:'job-apply',component:JobApplyComponent},
  {path:'job-posting',component:JobPostingComponent},
  {
    path:'cv-generation',component:CvGenerationComponent
  },
  {
    path:"jobdetail",
    component:JobDetailComponent,
    
  },
  {path:"chatbot",component:ChatbotComponent},
  {
    path:"jobdetail",
    component:JobDetailComponent,
    
  },
  {path:"assesmentportal",component:AssesmentPortalComponent},
  {path:"assesmenttest",component:AssesmentTestPortalComponent},
  {path:"test",component:SkilltestComponent},
  {path:'jobdetail',component:JobDetailComponent},
  {path: 'learning', component:LearningPortalComponent},

  // providing path for register and login 
  {path:"register",component:RegisterComponent},
  {path:"jobSeekerRegister",component:JobSeekerRegisterComponent},
  {path:"recruiterRegister",component:RecruiterRegisterComponent},
  {path:"userLogin",component:LoginComponent},
  {path:"update",component:UpdateDetailsComponent},
  {path:"update-user",component:UpdateUserDetailsComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
