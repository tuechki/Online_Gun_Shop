import { Injectable } from '@angular/core';
import {tokenNotExpired} from "angular2-jwt";
import {HttpRequest} from "@angular/common/http";

@Injectable()
export class AuthService {

  cachedRequests: Array<HttpRequest<any>> = [];

  public collectFailedRequest(request): void {
    this.cachedRequests.push(request);
  }

  public retryFailedRequests(): void {
    // retry the requests. this method can
    // be called after the token is refreshed
  }

  public getToken(): string {
    return localStorage.getItem('token');
  }

  public isAuthenticated(): boolean {

      const token = this.getToken();

      if(token != null){
        return true;
      }else{
        return false;
      }



  }

}
