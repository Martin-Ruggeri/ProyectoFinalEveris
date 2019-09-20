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

  planet: Planet = { id: null, name: "", size: null, dTO_Star: null };

  stars: Star[] = [];

  msjAlertName: String = "";
  msjAlertSize: String = "";
  msjAlertStar: String = "";


  constructor(private serviceStar: ServiceStar, private servicePlanet: ServicePlanet, private router: Router, private activatedRouter: ActivatedRoute) {
    this.activatedRouter.params.subscribe(
      (data) => {
        if (data.id != 0) {
          this.servicePlanet.getOne(data.id).subscribe(
            (data2) => {
              this.planet = data2
            })
        }
      });
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
    this.msjAlertName = "";
    this.msjAlertSize = "";
    this.msjAlertStar = "";
    // Valida datos ingresados
    let formValido: boolean = this.validarForm(this.planet);
    if (!formValido) return;

    // Guardar El Planeta
    if (this.planet.id == null) {
      this.servicePlanet.post(this.planet).subscribe(
        (data: Planet) => {
          this.planet = { id: null, name: "", size: null, dTO_Star: null },
            this.router.navigate(['/list-planet'])
        },
        () => {
          alert("Se produjo un error al intentar guardar el Planet")
        }
      );
    } else {
      this.servicePlanet.put(this.planet.id, this.planet).subscribe(
        (data) => {
          this.planet = { id: null, name: "", size: null, dTO_Star: null },
            this.router.navigate(['/list-planet'])
        },
        () => {
          alert("Se produjo un error al intentar guardar el Planet")
        }
      );
    }
  }

  validarForm(planet: Planet): boolean {

    if (this.planet.name == "" || this.planet.name == null || this.planet.size <= 0 || this.planet.size == null || this.planet.dTO_Star == null) {
      if (this.planet.name == "" || this.planet.name == null) this.msjAlertName = "El nombre no puede estar vacio";
      if (this.planet.size <= 0 || this.planet.size == null) this.msjAlertSize = "El tamaño no puede ser 0 o negativo";
      if (this.planet.dTO_Star == null) this.msjAlertStar = "Se debe asignar una estrella";

      return false;
    }
    return true;
  }

}
