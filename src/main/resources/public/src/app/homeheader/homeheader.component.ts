import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
@Component({
  selector: 'app-homeheader',
  templateUrl: './homeheader.component.html',
  styleUrls: ['./homeheader.component.scss']
})
export class HomeheaderComponent implements OnInit {

  submittedSearch = false;
  constructor(private _router: Router) { }

  ngOnInit() {
  }

  searchSubmit(){
    this.submittedSearch = true;
    alert("Search submitted");
    this._router.navigate(['/home']);

  }

}
