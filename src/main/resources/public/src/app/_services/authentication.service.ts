import { Injectable } from '@angular/core';
//this access the fake json server on localhost:3000

import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Router } from '@angular/router';
import { User } from '../_models/user';

import { catchError } from 'rxjs/operators';
import { throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  private _registerUrl = '../assets/data/users.json';
  // private _loginUrl='http://localhost:3000/login';
  private _loginUrl = '../assets/data/users.json';
  constructor(private http: HttpClient, private _router: Router) {}


  loginUser(user) {
      // return this.http.post<any>(this._loginUrl, user);
      return this.http.post<any>(this._loginUrl, user);
        // .map((res: Response) => res.json());


    // if(user.email === 'a' && user.password ==='a'){
    //   alert("user is logged in");
    //   this._router.navigate(['/home']);
    //   return true;
    // }else {
    //   alert("user is not correct");
    //   // return false;
    // }
    // return this.http.post<any>(this._loginUrl, user);
  }
  registerUser(user) {
    return this.http.post<any>(this._registerUrl, user);
  }

  getUsers() {
    return this.http.get<any>(this._loginUrl);
  }



  // loggedIn() {
  //   // return true;
  //   return !!/ocalStorage.getItem('token');
  // }


  logoutUser() {
    // localStorage.removeItem('token');
    alert("Logged out");
    this._router.navigate(['/index']);
  }



  //express server url
  // _url='http://localhost:3000/login';
  //
  // constructor(private http: HttpClient, private _router: Router) { }
  //
  // //make a post request to the server
  // login(user: User) {
  //   return this.http.post<any>(this._url, user)
  //     .pipe(catchError(this.errorHandler))
  // }
  //
  // errorHandler(error: HttpErrorResponse) {
  //   return throwError(error);
  // }
}
