import {ActivatedRouteSnapshot, Resolve, RouterStateSnapshot, Routes} from "@angular/router";
import {CustomerComponent} from "./customer.component";
import {PaginationUtil} from "../../shared/service/PaginationUtil";


export class CustomerResolvePagingParams implements Resolve<any> {
  constructor( private paginationUtil: PaginationUtil) {}

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
    const page = route.queryParams['page'] ? route.queryParams['page'] : '1';
    const sort = route.queryParams['sort'] ? route.queryParams['sort'] : 'id,asc';
    return {
      page: this.paginationUtil.parsePage(page),
      predicate: this.paginationUtil.parsePredicate(sort),
      ascending: this.paginationUtil.parseAscending(sort)
    };
  }
}

export const customerRoute: Routes = [
  {
    path: 'customer',
    component: CustomerComponent,
    resolve: {
      'pagingParams': CustomerResolvePagingParams
    },
    data: {
      pageTitle: 'Customers'
    }
  }
];
