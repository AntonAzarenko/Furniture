import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Details} from "../ui/details/details.component";

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
    return this.http.get('http://localhost:8080/detail');
  }

  getDetailsByModuleId(id: number) {
    console.log(id);
    return this.http.get('http://localhost:8080/detail/' + id);
  }

  deleteDetail(id: number) {
    // console.log(id);
    this.http.delete('http://localhost:8080/detail/' + id).subscribe();
  }

  deleteAll(list: Details[]) {
    console.log(list);
   return this.http.post<Details>('http://localhost:8080/detail/del', list, httpOptions).subscribe();
  }

  save(detail: Details){
    console.log(detail);
   return this.http.post<Details>('http://localhost:8080/detail', detail, httpOptions)
  }
}
