import { Component, OnInit } from '@angular/core';

import { Planet } from 'src/app/model/planet';
import { Star } from 'src/app/model/star';

import { ServiceStar } from 'src/app/services/service.star';

@Component({
  selector: 'app-add-planet',
  templateUrl: './add-planet.component.html',
  styleUrls: ['./add-planet.component.css']
})
export class AddPlanetComponent implements OnInit {
  planet: Planet = null;

  stars: Star[] = [];
  constructor(private serviceStar: ServiceStar) { }

  ngOnInit() {
    // Lleno la lista de stars
    this.serviceStar.getAll().subscribe(
      (data: Star[]) =>
        this.stars = data
    );
  }

}
