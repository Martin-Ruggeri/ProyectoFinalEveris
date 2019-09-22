import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { HomeComponent } from './components/home/home.component';

import { AddPlanetComponent } from './components/add-planet/add-planet.component'
import { AddStarComponent } from './components/add-star/add-star.component';

import { ListPlanetComponent } from './components/list-planet/list-planet.component';
import { ListStarComponent } from './components/list-star/list-star.component';


const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'add-planet/:id', component: AddPlanetComponent},
  {path: 'add-star/:id', component: AddStarComponent},
  {path: 'list-planet', component: ListPlanetComponent},
  {path: 'list-star', component: ListStarComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
