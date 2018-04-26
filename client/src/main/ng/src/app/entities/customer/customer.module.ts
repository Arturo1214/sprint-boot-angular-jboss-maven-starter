import {CUSTOM_ELEMENTS_SCHEMA, NgModule} from "@angular/core";
import {CustomerResolvePagingParams, customerRoute} from "./customer.route";
import {RouterModule} from "@angular/router";
import {CustomerComponent} from "./customer.component";
import {CustomerService} from "./customer.service";
import {SharedModule} from "../../shared";

const ENTITY_STATES = [
  ...customerRoute
];

@NgModule({
  imports: [
    SharedModule,
    RouterModule.forChild(ENTITY_STATES)
  ],
  declarations: [
    CustomerComponent
  ],
  entryComponents: [
    CustomerComponent
  ],
  providers: [
    CustomerService,
    CustomerResolvePagingParams
  ],
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class AppCustomerModule {}
