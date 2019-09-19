import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from 'rxjs';
import { Star } from '../model/star';

@Injectable({
  providedIn: 'root'
})
export class ServiceStar{

  URLStar   = "http://localhost:9000/api/v1/star/";

  constructor( public http: HttpClient) {}

  getOne(id:number): Observable<Star>{
   return this.http.get<Star>(this.URLStar + id);
  }
  
  getAll(): Observable<Star[]>{
    return this.http.get<Star[]>(this.URLStar);
  }

  post(star: Star): Observable<Star>{
    return this.http.post<Star>(this.URLStar, star);
  }

  put(id: number, star:Star): Observable<Star>{
    return this.http.put<Star>(this.URLStar + id, star);
  }

  delete(id: number): Observable<void>{
    return this.http.delete<void>(this.URLStar + id).pipe();
  }
}
