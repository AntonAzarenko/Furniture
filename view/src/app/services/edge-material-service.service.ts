import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class EdgeMaterialServiceService {

  constructor(private http: HttpClient) { }

  getAllEdge(){
    console.log(123);
    return this.http.get('http://localhost:8080/edge');
  }
}
