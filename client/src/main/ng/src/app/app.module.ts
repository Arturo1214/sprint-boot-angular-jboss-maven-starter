import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import {HttpClientModule} from "@angular/common/http";
import {FormsModule} from "@angular/forms";
import {AppHomeModule} from "./home";
import {AppRoutingModule} from "./app-routing.module";
import {ErrorComponent, FooterComponent, MainComponent, NavbarComponent} from "./layouts";


@NgModule({
  declarations: [
    MainComponent,
    NavbarComponent,
    ErrorComponent,
    FooterComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    AppRoutingModule,
    AppHomeModule
  ],
  providers: [],
  bootstrap: [MainComponent]
})
export class AppModule { }
