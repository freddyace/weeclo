import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) {
    this.getJSON().subscribe(data =>
      {
        console.log(data);
      }
    )
   }

   getJSON(): Observable<any> {
     // alert("get json");
    return this.http.get('../assets/data/users.json');
  }


}
