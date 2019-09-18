import { Component, OnInit } from '@angular/core';
import { Star } from 'src/app/model/star';

@Component({
  selector: 'app-add-star',
  templateUrl: './add-star.component.html',
  styleUrls: ['./add-star.component.css']
})
export class AddStarComponent implements OnInit {
  star:Star = null;
  constructor() { }

  ngOnInit() {
  }

}
