import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ServiceStar<Star>{

  URLStar   = "/api/v1/star/";

  constructor( public http: HttpClient) {}

  getOne(id:number): Observable<Star>{
   return this.http.get<Star>(this.URLStar + id);
  }
  getAll(): Observable<Star[]>{
    return this.http.get<Star[]>(this.URLStar);
  }
}
