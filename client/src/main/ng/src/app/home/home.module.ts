import {CUSTOM_ELEMENTS_SCHEMA, NgModule} from "@angular/core";
import {RouterModule} from "@angular/router";
import {HOME_ROUTE} from "./home.route";
import {HomeComponent} from "./home.component";

@NgModule({
  imports: [
    RouterModule.forChild([ HOME_ROUTE ])
  ],
  declarations: [
    HomeComponent,
  ],
  entryComponents: [

  ],
  providers: [

  ],
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class AppHomeModule {}
