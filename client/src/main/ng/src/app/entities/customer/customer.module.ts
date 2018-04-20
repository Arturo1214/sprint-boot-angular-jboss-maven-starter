import {CUSTOM_ELEMENTS_SCHEMA, NgModule} from "@angular/core";
import {customerRoute} from "./customer.route";
import {RouterModule} from "@angular/router";
import {CustomerComponent} from "./customer.component";

const ENTITY_STATES = [
  ...customerRoute
];

@NgModule({
  imports: [
    RouterModule.forChild(ENTITY_STATES)
  ],
  declarations: [
    CustomerComponent
  ],
  entryComponents: [
    CustomerComponent
  ],
  providers: [

  ],
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class AppCustomerModule {}
