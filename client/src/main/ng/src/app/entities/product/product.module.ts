import {productRoute} from "./product.route";
import {CUSTOM_ELEMENTS_SCHEMA, NgModule} from "@angular/core";
import {RouterModule} from "@angular/router";
import {ProductComponent} from "./product.component";
import {SharedModule} from "../../shared";

const ENTITY_STATES = [
  ...productRoute
];

@NgModule({
  imports: [
    SharedModule,
    RouterModule.forChild(ENTITY_STATES)
  ],
  declarations: [
    ProductComponent
  ],
  entryComponents: [
    ProductComponent
  ],
  providers: [],
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class AppProductModule {}
