import { Injectable } from '@angular/core';
import { Http, Response, Headers, RequestOptions } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import { SmsMessage } from '../sms-message';

@Injectable()
export class SmsMessageService {
  private baseUrl:string='https://moviedb-backend.azurewebsites.net/api';
  private headers = new Headers({'Content-Type':'application/json'})
  private options = new RequestOptions({headers:this.headers});
  private smsMessage:SmsMessage=new SmsMessage();

  constructor(private http: Http) { }

    getMessages(){
      return this.http.get(this.baseUrl+'/messages', this.options).map((response:Response) => response.json())
      .catch(this.errorHandler)
    }

    getMessage(id:Number){
      return this.http.get(this.baseUrl+'/messages/'+id, this.options).map((response:Response) => response.json())
      .catch(this.errorHandler);
    }

    deleteMessage(id:Number){
      return this.http.delete(this.baseUrl+'/messages/'+id, this.options).map((response:Response) => response.json())
      .catch(this.errorHandler);
    }

    createMessage(message:SmsMessage){
      return this.http.post(this.baseUrl+'/messages/create', JSON.stringify(message), this.options).map((response:Response) => response.json())
      .catch(this.errorHandler);
    }

    updateMessage(message:SmsMessage){
      return this.http.put(this.baseUrl+'/messages/update', JSON.stringify(message), this.options).map((response:Response) => response.json())
      .catch(this.errorHandler);
    }

    errorHandler(error:Response){
      return Observable.throw(error || "SERVER ERROR");
    }

    setter(smsMessage:SmsMessage){
      this.smsMessage = smsMessage;
    }

    getter(){
      return this.smsMessage;
    }
}
