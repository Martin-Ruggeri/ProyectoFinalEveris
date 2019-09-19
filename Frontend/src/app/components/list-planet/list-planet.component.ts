import { Component, OnInit } from '@angular/core';
import { ServicePlanet } from 'src/app/services/service.planet';
import { Planet } from 'src/app/model/planet';

@Component({
  selector: 'app-list-planet',
  templateUrl: './list-planet.component.html',
  styleUrls: ['./list-planet.component.css']
})
export class ListPlanetComponent implements OnInit {

  planets: Planet[] = [];

  constructor(private servicePlanet: ServicePlanet) { }

  ngOnInit() {
    // Lleno la lista de planets
    this.servicePlanet.getAll().subscribe(
      (data: Planet[]) =>
        this.planets = data
    );
  }
  delete(id: number){
    this.servicePlanet.delete(id).subscribe(
      () => this.planets = this.planets.filter((planet) => planet.id !== id),
      (err) =>  console.log("El planet: " + id + " No se puede eliminar")
    );
  }

}
