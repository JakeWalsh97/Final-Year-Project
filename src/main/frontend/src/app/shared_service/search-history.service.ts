import { Injectable } from '@angular/core';
import { Http, Response, Headers, RequestOptions } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import { SearchHistory } from '../search-history';
import { response } from 'express';

@Injectable()
export class SearchHistoryService {
  private baseUrl:string='https://moviedb-backend.azurewebsites.net/api';
  private headers = new Headers({'Content-Type':'application/json'})
  private options = new RequestOptions({headers:this.headers});
  private searchHistory:SearchHistory=new SearchHistory();

  constructor(private http: Http) { }

  getAllSearchHistory(){
    return this.http.get(this.baseUrl+'/searchHistory', this.options).map((response:Response) => response.json())
    .catch(this.errorHandler);
  }

  getSearchHistory(id:Number){
    return this.http.get(this.baseUrl+'/searchHistory/'+id, this.options).map((response:Response) => response.json())
    .catch(this.errorHandler);
  }

  deleteSearchHistory(id:Number){
    return this.http.delete(this.baseUrl+'/searchHistory/'+id, this.options).map((response:Response) => response.json())
    .catch(this.errorHandler);
  }

  createSearchHistory(searchHistory:SearchHistory){
    return this.http.post(this.baseUrl+'/searchHistory/create', JSON.stringify(searchHistory), this.options).map((response:Response) => response.json())
    .catch(this.errorHandler);
  }

  updateSearchHistory(searchHistory:SearchHistory){
    return this.http.put(this.baseUrl+'/searchHistory/update', JSON.stringify(searchHistory), this.options).map((response:Response) => response.json())
    .catch(this.errorHandler);
  }

  errorHandler(error:Response){
    return Observable.throw(error || "SERVER ERROR");
  }

  setter(searchHistory:SearchHistory){
    this.searchHistory=searchHistory;
  }

  getter(){
    return this.searchHistory;
  }
}
