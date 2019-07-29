import { Injectable } from '@angular/core';
import { Http, Response, Headers, RequestOptions } from '@angular/http'
import { Observable } from 'rxjs/Observable';
import { Review } from '../review';

import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';

@Injectable({
  providedIn: 'root'
})
export class ReviewService {
  private baseUrl:string='https://moviedb-backend.azurewebsites.net/api';
  private headers = new Headers({'Content-Type':'application/json'})
  private options = new RequestOptions({headers:this.headers});
  private review:Review = new Review();

  constructor(private http: Http) { }

  getReviews(){
    return this.http.get(this.baseUrl+"/reviews", this.options).map((response:Response) => response.json())
    .catch(this.errorHandler)
  }

  getReview(id:Number){
    return this.http.get(this.baseUrl+"/review/"+id, this.options).map((response:Response) => response.json())
    .catch(this.errorHandler)
  }

  deleteReview(id:Number){
    return this.http.delete(this.baseUrl+"/review/"+id, this.options).map((response:Response) => response.json())
    .catch(this.errorHandler)
  }

  createReview(review:Review){
    return this.http.post(this.baseUrl+"/review/create", JSON.stringify(review), this.options).map((response:Response) => response.json())
    .catch(this.errorHandler)
  }

  updateReview(review:Review){
    return this.http.put(this.baseUrl+"/review/create", JSON.stringify(review), this.options).map((response:Response) => response.json())
    .catch(this.errorHandler)
  }

  errorHandler(error:Response){
    return Observable.throw(error || "SERVER ERROR");
  }

  setter(review:Review){
    this.review=review;
  }

  getter(){
    return this.review;
  }
}
