import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {

  constructor(private http: HttpClient) {
      this.getJSON().subscribe(data =>
      {
        console.log(data);
      })
   }

   getJSON(): Observable<any> {
     return this.http.get('../assets/data/categories.json');
   }
}
