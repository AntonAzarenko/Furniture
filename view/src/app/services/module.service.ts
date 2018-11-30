import {Injectable} from '@angular/core';
import {HttpClient, HttpErrorResponse, HttpHeaders} from "@angular/common/http";
import {FurnitureModule} from "../ui/module/module.component";
import {Observable, throwError} from "rxjs/index";
import {catchError} from "rxjs/internal/operators";


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

  getAll() {
    return this.http.get('http://localhost:8080/module')
  }

  save(moduleF: FurnitureModule) {
   return this.http.post<FurnitureModule>('http://localhost:8080/module', moduleF, httpOptions);
  }

  delete(id: number){
    console.log(id);
    this.http.delete('http://localhost:8080/module/'+ id).subscribe();
  }
}
