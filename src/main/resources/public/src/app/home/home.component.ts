import { Component, OnInit } from '@angular/core';

import { UserService } from '../_services/user.service';
import { User } from '../_models/user';

import * as $ from 'jquery';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  users: Object;

  constructor(private userService: UserService) { }

  ngOnInit() {
    this.userService.getJSON()
      .subscribe( data => {
        this.users = data.users;
        console.log(data);
      });
  }

}
