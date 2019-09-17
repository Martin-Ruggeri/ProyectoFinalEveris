import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ServicePlanet<Planet>{
  
    URLPlanet = "/api/v1/planet/";

  constructor( public http: HttpClient) {}


  getOne(id:number): Observable<Planet>{
   return this.http.get<Planet>(this.URLPlanet + id);
  }
  getAll(): Observable<Planet[]>{
    return this.http.get<Planet[]>(this.URLPlanet);
  }
}
