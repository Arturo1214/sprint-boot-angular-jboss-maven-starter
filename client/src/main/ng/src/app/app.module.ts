import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import {AppHomeModule} from "./home";
import {AppRoutingModule} from "./app-routing.module";
import {ErrorComponent, FooterComponent, MainComponent, NavbarComponent} from "./layouts";
import {AppEntityModule} from "./entities/entity.module";
import {SharedModule} from "./shared";


@NgModule({
  declarations: [
    MainComponent,
    NavbarComponent,
    ErrorComponent,
    FooterComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    SharedModule,
    AppHomeModule,
    AppEntityModule
  ],
  providers: [],
  bootstrap: [MainComponent]
})
export class AppModule { }
