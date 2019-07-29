import { Injectable } from '@angular/core';
import { Http, Response, Headers, RequestOptions } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import { Query } from '../query';

@Injectable()
export class QueryService {
  private baseUrl:string='https://moviedb-backend.azurewebsites.net/api';
  private headers = new Headers({'Content-Type':'application/json'})
  private options = new RequestOptions({headers:this.headers});
  private query:Query=new Query();

  constructor(private http: Http) { }

  getQueries(){
    return this.http.get(this.baseUrl+'/queries', this.options).map((response:Response) => response.json())
    .catch(this.errorHandler)
  }

  getQuery(id:Number){
    return this.http.get(this.baseUrl+'/queries/'+id, this.options).map((response:Response) => response.json())
    .catch(this.errorHandler)
  }

  deleteQuery(id:Number){
    return this.http.delete(this.baseUrl+'/queries/'+id, this.options).map((response:Response) => response.json())
    .catch(this.errorHandler)
  }

  createQuery(query:Query){
    return this.http.post(this.baseUrl+"/queries/create", JSON.stringify(query), this.options).map((response:Response) => response.json())
    .catch(this.errorHandler);
  }

  updateQuery(query:Query){
    return this.http.put(this.baseUrl+"/queries/update", JSON.stringify(query), this.options).map((response:Response) => response.json())
    .catch(this.errorHandler);
  }

  errorHandler(error:Response){
    return Observable.throw(error || "SERVER ERROR");
  }

  setter(query:Query){
    this.query=query;
  }

  getter(){
    return this.query;
  }
}
