import {CUSTOM_ELEMENTS_SCHEMA, NgModule} from "@angular/core";
import {AppCustomerModule} from "./customer/customer.module";
import {AppProductModule} from "./product/product.module";

@NgModule({
  imports: [
    AppCustomerModule,
    AppProductModule
  ],
  declarations: [],
  entryComponents: [],
  providers: [],
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class AppEntityModule {}
