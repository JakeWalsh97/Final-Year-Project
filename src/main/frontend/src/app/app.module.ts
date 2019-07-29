import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms'
import { HttpModule } from '@angular/http'

import { AppComponent } from './app.component';
import { ListuserComponent } from './components/listuser/listuser.component';
import { UserFormComponent } from './components/user-form/user-form.component';
import { UserService } from './shared_service/user.service';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { NeedAuthGuard } from './need-auth.guard';
import { ReviewService } from './shared_service/review.service';
import { ReviewComponent } from './components/review/review.component';
import { AdminComponent } from './components/admin/admin.component';
import { FavouriteComponent } from './components/favourite/favourite.component'
import { FavouriteService } from './shared_service/favourite.service';
import { QueryService } from './shared_service/query.service';
import { QueryComponent } from './components/query/query.component';
import { SmsMessageComponent } from './components/sms-message/sms-message.component';
import { SmsMessageService } from './shared_service/sms-message.service';
import { SearchHistoryService } from './shared_service/search-history.service';

const appRoutes:Routes=[
  {path: "admin", component:AdminComponent},
  {path:"", component:HomeComponent},
];

@NgModule({
  declarations: [
    AppComponent,
    ListuserComponent,
    UserFormComponent,
    HomeComponent,
    LoginComponent,
    ReviewComponent,
    AdminComponent,
    FavouriteComponent,
    QueryComponent,
    SmsMessageComponent,
  ],
  imports: [
    BrowserModule,
    HttpModule,
    HttpClientModule,
    RouterModule.forRoot(appRoutes),
    FormsModule,
  ],
  providers: [UserService, ReviewService, FavouriteService, QueryService, SmsMessageService, SearchHistoryService],
  bootstrap: [AppComponent]
})
export class AppModule { }
