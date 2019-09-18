import { Component, OnInit } from '@angular/core';

import { Planet } from 'src/app/model/planet';
import { Star } from 'src/app/model/star';

import { ServiceStar } from 'src/app/services/service.star';
import { ServicePlanet } from 'src/app/services/service.planet';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-add-planet',
  templateUrl: './add-planet.component.html',
  styleUrls: ['./add-planet.component.css']
})
export class AddPlanetComponent implements OnInit {

  planet: Planet = { id: null, name: "", size: 0, star: null };

  stars: Star[] = [];
  starSelect: Star = null;

  constructor(private serviceStar: ServiceStar,
    private servicePlanet: ServicePlanet,
    private router: Router,
    private activatedRouter: ActivatedRoute) {
    this.activatedRouter.params.subscribe(
      (data) => {
        if (data.id != 0) {
          this.servicePlanet.getOne(data.id).subscribe(
            (data2) => this.planet = data2)
        }
      }
    );
  }

  ngOnInit() {
    // Lleno la lista de stars
    this.serviceStar.getAll().subscribe(
      (data: Star[]) =>
        this.stars = data
    );
  }

  confirmar() {
    this.planet.name = this.planet.name.trim();
    this.planet.star = this.starSelect;

    // Valida datos ingresados
    let formValido: boolean = this.validarForm(this.planet);
    if (!formValido) return;

    // Guardar El Planeta
    if (this.planet.id == 0 || this.planet.id == null) {
      this.servicePlanet.post(this.planet).subscribe(
        (data) => {
          this.planet = { id: null, name: "", size: 0, star: null },
            this.router.navigate(['/home'])
        });
    } else {
      this.servicePlanet.put(this.planet.id,this.planet).subscribe(
        (data) => {
          this.planet = { id: null, name: "", size: 0, star: null },
            this.router.navigate(['/home'])
        });
    }
  }

  validarForm(planet: Planet): boolean {
    if (this.planet.name == "" || this.planet.name == null) return false;
    if (this.planet.size <= 0 || this.planet.size == null) return false;
    if (this.planet.star == null) return false;
    return true;
  }
}
