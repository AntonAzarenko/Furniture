import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class ColorService {

  constructor(private http: HttpClient) { }

  getAllColorMaterial(){
    return this.http.get('https://back-end-furniture.herokuapp.com/furniture/color/all');
  }
}
