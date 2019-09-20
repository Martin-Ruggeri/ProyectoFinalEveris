import { Component, OnInit } from '@angular/core';

import { Star } from 'src/app/model/star';
import { ServiceStar } from 'src/app/services/service.star';

import { Router, ActivatedRoute } from '@angular/router';


@Component({
  selector: 'app-add-star',
  templateUrl: './add-star.component.html',
  styleUrls: ['./add-star.component.css']
})
export class AddStarComponent implements OnInit {

  star: Star = { id: null, name: "", density: null };

  msjAlertName: String = "";
  msjAlertDensity: String = "";

  constructor( 
    private serviceStar: ServiceStar,
    private router: Router,
    private activatedRouter: ActivatedRoute
  ){
    this.activatedRouter.params.subscribe(
      (data) => {
        if (data.id != 0) {
          this.serviceStar.getOne(data.id).subscribe(
            (data2) => this.star = data2)
        }
      }
    );
  }

  ngOnInit() {
  }

  confirmar() {
    this.star.name = this.star.name.trim();
    this.msjAlertName = "";
    this.msjAlertDensity = "";
    // Validar datos Ingresados
    let formValido: boolean = this.validarForm(this.star);
    if (!formValido) return;

    // Guardar La Star
    if (this.star.id == 0 || this.star.id == null) {
      this.serviceStar.post(this.star).subscribe(
        (data) => {
          this.star = { id: null, name: "", density: null },
            this.router.navigate(['/list-star'])
        },
        () => {
          alert("Se produjo un error al intentar guardar la Star")
        }
      );
    } else {
      this.serviceStar.put(this.star.id, this.star).subscribe(
        (data) => {
          this.star = { id: null, name: "", density: null },
            this.router.navigate(['/list-star'])
        },
        () => {
          alert("Se produjo un error al intentar guardar la Star")
        }
      );
    }
  }

  validarForm(star: Star): boolean {
    if (star.name == "" || star.name == null || star.density <= 0 || star.density == null) {
      if (star.name == "" || star.name == null) this.msjAlertName = "El nombre no puede estar vacio";
      if (star.density <= 0 || star.density == null) this.msjAlertDensity = "La densidad no puede ser 0 o negativo";

      return false;
    }
    return true;
  }
}
