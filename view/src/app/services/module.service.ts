import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {FurnitureModule} from "../entity/FurnitureModule";

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json',
    'Headers': 'json'
  })
};

@Injectable({
  providedIn: 'root'
})
export class ModuleService {

  constructor(private http: HttpClient) {
  }

  getAll(id: number) {
    console.log(id);
    return this.http.get('https://back-end-furniture.herokuapp.com/furniture/module/' + id);
  }

  save(moduleF: FurnitureModule) {
    console.log(moduleF);
    return this.http.post<FurnitureModule>('https://back-end-furniture.herokuapp.com/furniture/module', moduleF, httpOptions);
  }

  delete(id: number) {
    console.log(id);
    this.http.delete('https://back-end-furniture.herokuapp.com/furniture/module/' + id).subscribe();
  }
}
