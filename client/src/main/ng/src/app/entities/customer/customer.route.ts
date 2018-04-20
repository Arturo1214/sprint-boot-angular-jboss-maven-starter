import {Routes} from "@angular/router";
import {CustomerComponent} from "./customer.component";

export const customerRoute: Routes = [
  {
    path: 'customer',
    component: CustomerComponent,
    data: {
      pageTitle: 'Customers'
    }
  }
];
