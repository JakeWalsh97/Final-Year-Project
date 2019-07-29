import { Component, OnInit } from '@angular/core';
import { UserService } from '../../shared_service/user.service';
import { User } from '../../user';
import { Review } from '../../review';
import { Query } from '../../query';
import { QueryService } from '../../shared_service/query.service';
import { ReviewService } from '../../shared_service/review.service';
import { Http, Response, Headers, RequestOptions } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import { Router } from '@angular/router';

import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  private baseUrl:string='http://localhost:8080/api';
  private headers = new Headers({'Content-Type':'application/json'})
  private options = new RequestOptions({headers:this.headers});
  public users:User[];
  public reviews:Review[];
  public queries:Query[];
  query:Query = new Query();
  isQueryFound:boolean;
  isAddressed = true;

  constructor(private _userService:UserService, private _reviewService:ReviewService, private _queryService:QueryService, private _router:Router, private http: Http) { }

  ngOnInit() {
    this._userService.getUsers().subscribe((users) => {
      console.log(users);
      this.users=users;
  }, (error) => {
    console.log(error);
  })

  this._reviewService.getReviews().subscribe((reviews) => {
    console.log(reviews);
    this.reviews=reviews;
  }, (error) => {
    console.log(error);
  })

  this._queryService.getQueries().subscribe((queries) => {
    console.log(queries);
    this.queries=queries;
  }, (error) => {
    console.log(error);
  })
}

  deleteUser(user){
    this._userService.deleteUser(user.id).subscribe((data) => {
      this.users.splice(this.users.indexOf(user),1);
    },(error)=> {
      console.log(error);
    })
  }

  deleteReview(review){
    this._reviewService.deleteReview(review.id).subscribe((data) => {
      this.reviews.splice(this.reviews.indexOf(review),1);
    },(error)=> {
      console.log(error);
    })
  }

  addressQuery(query, responseText){
    this.query = query;
    this.isQueryFound = false;
    for(var i = 0; i < this.queries.length; i++){
      if (this.queries[i].id == this.query.id){
        this.isQueryFound = true;
        this.queries[i].responseText = responseText;

        this._queryService.updateQuery(this.queries[i]).subscribe((data) => {
          console.log(this.queries);
        }, (error) => {
          console.log(error);
        })

        i = this.queries.length;
      }
    }
  }

  deleteQuery(query){
    this._queryService.deleteQuery(query.id).subscribe((data) => {
      this.queries.splice(this.queries.indexOf(query),1);
    }, (error) => {
      console.log(error);
    })
  }

  errorHandler(error:Response){
    return Observable.throw(error || "SERVER ERROR");
  }

}
