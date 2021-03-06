// ----------- IMPORTS -------------------------
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { NavbarComponent } from './components/navbar/navbar.component';

import { AddPlanetComponent } from './components/add-planet/add-planet.component';
import { AddStarComponent } from './components/add-star/add-star.component';
import { HomeComponent } from './components/home/home.component';
import { ListPlanetComponent } from './components/list-planet/list-planet.component';
import { ListStarComponent } from './components/list-star/list-star.component';

import { HttpClientModule } from '@angular/common/http'; 

import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    AddPlanetComponent,
    AddStarComponent,
    HomeComponent,
    ListPlanetComponent,
    ListStarComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
