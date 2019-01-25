import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Details} from "../entity/Details";

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json',
    'Headers': 'json'
  })
};

@Injectable({
  providedIn: 'root'
})
export class DetailService {

  constructor(private http: HttpClient) {
  }

  getAllDetail() {
    return this.http.get('http://localhost:8080/furniture/detail');
  }

  getDetailsByModuleId(id: number) {
    return this.http.get('http://localhost:8080/furniture/detail/' + id);
  }

  deleteDetail(id: number) {
     console.log(id);
    this.http.delete('http://localhost:8080/furniture/detail/' + id).subscribe();
  }

  deleteAll(list: Details[]) {
    console.log(list);

    list.forEach(function (value, index, array) {

    });
     this.http.delete<Details>('http://localhost:8080/furniture/detail/del/' + list).subscribe();
  }

  save(detail: Details) {
    console.log(detail);
    return this.http.post<Details>('http://localhost:8080/furniture/detail', detail, httpOptions)
  }
}
