import { Injectable } from '@angular/core';
import { Http, Response, Headers, RequestOptions } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import { Favourite } from '../favourite';

@Injectable()
export class FavouriteService {
  private baseUrl:string='https://moviedb-backend.azurewebsites.net/api';
  private headers = new Headers({'Content-Type':'application/json'})
  private options = new RequestOptions({headers:this.headers});
  private favourite:Favourite=new Favourite();

  constructor(private http: Http) { }

  getFavourites(){
    return this.http.get(this.baseUrl+'/favourites', this.options).map((response:Response) => response.json())
    .catch(this.errorHandler) 
  }

  getFavourite(id:Number){
    return this.http.get(this.baseUrl+'/favourites/'+id, this.options).map((response:Response) => response.json())
    .catch(this.errorHandler) 
  }

  deleteFavourite(id:Number){
    return this.http.delete(this.baseUrl+'/favourites/'+id, this.options).map((response:Response) => response.json())
    .catch(this.errorHandler)
  }

  createFavourite(favourite:Favourite){
    return this.http.post(this.baseUrl+"/favourites/create", JSON.stringify(favourite), this.options).map((response:Response) => response.json())
    .catch(this.errorHandler)
  }

  updateFavourite(favourite:Favourite){
    return this.http.put(this.baseUrl+"/favourites/update", JSON.stringify(favourite), this.options).map((response:Response) => response.json())
    .catch(this.errorHandler)
  }

  errorHandler(error:Response){
    return Observable.throw(error || "SERVER ERROR");
  }

  setter(favourite:Favourite){
    this.favourite=favourite;
  }

  getter(){
    return this.favourite;
  }
}
