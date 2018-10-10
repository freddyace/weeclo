import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';

import { User } from '../_models/user';
import { AuthenticationService } from '../_services/authentication.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  //variables
  submittedLogin = false; //to check if form is submitted
  userModel = new User('', '');
  errorMessage = '';

  constructor(private _authService: AuthenticationService, private _router: Router){}

  ngOnInit(){}

  //when login form is submitted
  loginSubmit(){
    this.submittedLogin = true;
    console.log(this.userModel);
    alert('submitted');
    this._authService.loginUser(this.userModel)
      .subscribe(
        data => console.log("success", data),
        error => this.errorMessage = error.statusText
      );
    this._router.navigate(['/home']);

  }
  //reactive form stuff
  // loginForm: FormGroup;
  //
  // constructor(private fb:FormBuilder, private router: Router) {}
  //
  // ngOnInit(){
  //   this.loginForm = this.fb.group({
  //     email: ['', Validators.required],
  //     password: ['', Validators.required]
  //   });
  // }
  // get f() {return this.loginForm.controls};
  //
  // submitLogin(data){
  //   alert(data.email);
  //     if(data.email == 'a' && data.password =='a') {
  //       alert("Login Successful");
  //       this.router.navigate(['/home']);
  //     }else {
  //       alert("Login Unsuccessful");
  //       return;
  //     }
  // }

}
