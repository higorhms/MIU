import { Injectable } from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor
} from '@angular/common/http';
import { Observable } from 'rxjs';

import { AuthenticationService } from './authentication.service';
import { environment } from '../environments/environment';

@Injectable()
export class AuthenticationInterceptor implements HttpInterceptor {

  constructor(
    private _authenticationService: AuthenticationService
  ) { }

  intercept(request: HttpRequest<unknown>, next: HttpHandler): Observable<HttpEvent<unknown>> {
    const token = this._authenticationService.token;

    if (token) {
      request = request.clone({
        setHeaders: {
          authorization: environment.BEARER + token,
        }
      })
    }

    return next.handle(request);
  }
}
