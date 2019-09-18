import { Component, OnInit } from '@angular/core';

import { ServicePlanet } from 'src/app/services/service.planet';
import { ServiceStar } from 'src/app/services/service.star';

import { Planet } from 'src/app/model/planet';
import { Star } from 'src/app/model/star';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(private servicePlanet: ServicePlanet, 
              private serviceStar:ServiceStar) {}
  
  planets:Planet[] = [];
  stars:Star[] = [];

  ngOnInit() {    
    // Lleno la lista de planets
    this.servicePlanet.getAll().subscribe(
      (data: Planet[]) => 
        this.planets = data
      );

    // Lleno la lista de stars
    this.serviceStar.getAll().subscribe(
      (data: Star[]) =>
        this.stars = data
      );
  }

  deletePlanet(id: number){
    this.servicePlanet.delete(id).subscribe(
      () => this.planets = this.planets.filter((planet) => planet.id !== id),
      (err) =>  console.log("El planet: " + id + " No se puede eliminar")
    );
  }

  deleteStar(id: number){
    this.serviceStar.delete(id).subscribe(
      () => this.stars = this.stars.filter((star) => star.id !== id),
      (err) => console.log("La star: " + id + " No se puede eliminar")  // Nunca entra por aca
      );
  }

}
