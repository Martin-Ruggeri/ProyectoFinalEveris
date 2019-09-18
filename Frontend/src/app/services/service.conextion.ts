import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from 'rxjs';
import { Base } from '../model/base';


import { Planet } from '../model/planet';

@Injectable({
  providedIn: 'root'
})
export class ServiceConextion<tipo extends Base>{
    
  URL = "/api/v1/"+  + "/";
  
  constructor(private http: HttpClient) {}


  
  getOne(id:number): Observable<tipo>{
   return this.http.get<tipo>(this.URL + id);
  }
  getAll(): Observable<tipo[]>{
    return this.http.get<tipo[]>(this.URL);
  }
}