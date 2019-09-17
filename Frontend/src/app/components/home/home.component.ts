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

  constructor(private servicePlanet: ServicePlanet<Planet>, 
              private serviceStar:ServiceStar<Star>) {}
  
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

}
