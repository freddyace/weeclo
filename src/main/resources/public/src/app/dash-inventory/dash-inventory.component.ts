import { Component, OnInit } from '@angular/core';

import { UserService } from '../_services/user.service';
import { User } from '../_models/user';

@Component({
  selector: 'app-dash-inventory',
  templateUrl: './dash-inventory.component.html',
  styleUrls: ['./dash-inventory.component.scss']
})
export class DashInventoryComponent implements OnInit {

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
