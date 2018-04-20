import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import {HttpClientModule} from "@angular/common/http";
import {FormsModule} from "@angular/forms";
import {AppHomeModule} from "./home";
import {AppRoutingModule} from "./app-routing.module";
import {ErrorComponent, FooterComponent, MainComponent, NavbarComponent} from "./layouts";
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import {AppEntityModule} from "./entities/entity.module";


@NgModule({
  declarations: [
    MainComponent,
    NavbarComponent,
    ErrorComponent,
    FooterComponent
  ],
  imports: [
    BrowserModule,
    NgbModule.forRoot(),
    HttpClientModule,
    FormsModule,
    AppRoutingModule,
    AppHomeModule,
    AppEntityModule
  ],
  providers: [],
  bootstrap: [MainComponent]
})
export class AppModule { }
