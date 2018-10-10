import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent implements OnInit {

  showFav:boolean = true;
  constructor() { }

  ngOnInit() {
  }

  showFavorites(){
    if(this.showFav) {
      this.showFav = false;
    }else {
      this.showFav = true;
    }
  }

}
