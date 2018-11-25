import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class DetailService {

  constructor(private http: HttpClient) { }


  getAllDetail(){
    return this.http.get('http://localhost:8080/detail');
  }
}
