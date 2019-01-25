import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {FurnitureModule} from "../ui/modules/module.component";

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
    return this.http.get('http://localhost:8080/furniture/module/' + id);
  }

  save(moduleF: FurnitureModule) {
    console.log(moduleF);
    return this.http.post<FurnitureModule>('http://localhost:8080/furniture/module', moduleF, httpOptions);
  }

  delete(id: number) {
    console.log(id);
    this.http.delete('http://localhost:8080/furniture/module/' + id).subscribe();
  }
}
