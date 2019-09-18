import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { HomeComponent } from './components/home/home.component';
import { AddPlanetComponent } from './components/add-planet/add-planet.component'
import { AddStarComponent } from './components/add-star/add-star.component';


const routes: Routes = [
  {path: 'home', component: HomeComponent},
  {path: 'add-planet/:id', component: AddPlanetComponent},
  {path: 'add-star/:id', component: AddStarComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
