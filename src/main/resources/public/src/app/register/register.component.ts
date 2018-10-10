import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthenticationService } from '../_services/authentication.service';
import { HttpClient } from '@angular/common/http';
import { User } from '../_models/user';


@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {
  submittedRegister = false;
  errorMessage = '';
  userModel = new User('', '');


  users: object[];

  constructor(private http: HttpClient,
    private _authService: AuthenticationService, private _router: Router) {}

  ngOnInit() {
    // this.getUsers();
  }
  //
  // getUsers() {
  //   this._authService.get('../assets/data/users2.json')
  //     .subscribe(res =>
  //       {
  //         let res = users[0];
  //         // alert(ci);
  //         this.users = res['users'];
  //       });
  //       // this.users = res);
  //   // console.log(this.users);
  // }

  registerSubmit() {
    this.submittedRegister = true;
    this._authService.loginUser(this.userModel)
      .subscribe(
        data => {
          // data => this.something.push(data);
          console.log("success", data);

        },
        error => this.errorMessage = error.statusText
      );
    this._router.navigate(['/home']);
    alert("submitted");
  }

  // registerForm: FormGroup;
  //
  // constructor(private fb:FormBuilder, private router: Router) {}
  //
  // ngOnInit(){
  //   this.registerForm = this.fb.group({
  //     fname: ['', Validators.required],
  //     lname: ['', Validators.required]
  //   });
  // }
  // get f() {return this.registerForm.controls};
  //
  // submitRegister(data){
  //   alert(data.fname);
  //   // submitRegister(data) {
  //     if(data.fname == 'a' && data.lname =='a') {
  //       alert("Register Successful");
  //       this.router.navigate(['/home']);
  //     }else {
  //       alert("Register Unsuccessful");
  //       return;
  //     }
  // }

}
