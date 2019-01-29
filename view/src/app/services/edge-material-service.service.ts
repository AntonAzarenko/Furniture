import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class EdgeMaterialServiceService {

  constructor(private http: HttpClient) { }

  getAllEdge(){
    return this.http.get('https://back-end-furniture.herokuapp.com/furniture/edge');
  }
}
