import {productRoute} from "./product.route";
import {CUSTOM_ELEMENTS_SCHEMA, NgModule} from "@angular/core";
import {RouterModule} from "@angular/router";
import {ProductComponent} from "./product.component";

const ENTITY_STATES = [
  ...productRoute
];

@NgModule({
  imports: [
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
