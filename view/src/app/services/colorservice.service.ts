import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class ColorserviceService {

  constructor(private http: HttpClient) { }

  getAllColorMaterail(){
    return this.http.get('http://localhost:8080/color/all');
  }
}
