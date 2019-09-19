import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from 'rxjs';
import { Planet } from '../model/planet';

@Injectable({
  providedIn: 'root'
})
export class ServicePlanet{
  
    URLPlanet = "http://localhost:9000/api/v1/planet/";

  constructor( public http: HttpClient) {}


  getOne(id:number): Observable<Planet>{
   return this.http.get<Planet>(this.URLPlanet + id);
  }
  getAll(): Observable<Planet[]>{
    return this.http.get<Planet[]>(this.URLPlanet);
  }

  post(planet: Planet): Observable<Planet>{
    return this.http.post<Planet>(this.URLPlanet, planet);
  }

  put(id: number, planet:Planet): Observable<Planet>{
    return this.http.put<Planet>(this.URLPlanet + id, planet);
  }

  delete(id: number): Observable<void>{
    return this.http.delete<void>(this.URLPlanet + id).pipe();
  }
}
