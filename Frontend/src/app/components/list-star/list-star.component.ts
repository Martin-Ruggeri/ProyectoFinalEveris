import { Component, OnInit } from '@angular/core';
import { Star } from 'src/app/model/star';
import { ServiceStar } from 'src/app/services/service.star';

@Component({
  selector: 'app-list-star',
  templateUrl: './list-star.component.html',
  styleUrls: ['./list-star.component.css']
})
export class ListStarComponent implements OnInit {

  stars: Star[] = [];

  constructor(private serviceStar:ServiceStar) { }

  ngOnInit() {
    // Lleno la lista de stars
    this.serviceStar.getAll().subscribe(
      (data: Star[]) =>
        this.stars = data
    );
  }

  delete(id: number){
    this.serviceStar.delete(id).subscribe(
      () => this.stars = this.stars.filter((star) => star.id !== id),
      (err) => console.log("La star: " + id + " No se puede eliminar")  // Nunca entra por aca
      );
  }

}
