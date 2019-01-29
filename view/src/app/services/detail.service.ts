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
    return this.http.get('https://back-end-furniture.herokuapp.com/furniture/detail');
  }

  getDetailsByModuleId(id: number) {
    return this.http.get('https://back-end-furniture.herokuapp.com/furniture/detail/' + id);
  }

  deleteDetail(id: number) {
     console.log(id);
    this.http.delete('https://back-end-furniture.herokuapp.com/furniture/detail/' + id).subscribe();
  }

  deleteAll(list: Details[]) {
    console.log(list);

    list.forEach(function (value, index, array) {

    });
     this.http.delete<Details>('https://back-end-furniture.herokuapp.com/furniture/detail/del/' + list).subscribe();
  }

  save(detail: Details) {
    console.log(detail);
    return this.http.post<Details>('https://back-end-furniture.herokuapp.com/furniture/detail', detail, httpOptions)
  }
}
