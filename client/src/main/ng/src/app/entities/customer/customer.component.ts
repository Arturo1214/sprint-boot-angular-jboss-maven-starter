import {Component, OnDestroy, OnInit} from '@angular/core';
import {Customer} from "./customer.model";
import {CustomerService} from "./customer.service";
import {ActivatedRoute} from "@angular/router";
import {ParseLinks, ITEMS_PER_PAGE} from "../../shared";
import {HttpResponse} from "@angular/common/http";

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent implements OnInit, OnDestroy {


  customers: Customer[];
  routeData: any;
  links: any;
  totalItems: any;
  queryCount: any;
  itemsPerPage: any;
  page: any;
  predicate: any;
  previousPage: any;
  reverse: any;

  constructor(
    private customerService: CustomerService,
    private parseLinks: ParseLinks,
    private activatedRoute: ActivatedRoute
  ) {
    this.itemsPerPage = ITEMS_PER_PAGE;
    this.routeData = this.activatedRoute.data.subscribe( (data) => {
      this.page = data['pagingParams'].page;
      this.previousPage = data['pagingParams'].page;
      this.reverse = data['pagingParams'].ascending;
      this.predicate = data['pagingParams'].predicate;
    });
  }

  ngOnInit() {
    this.loadAll();
  }

  ngOnDestroy(): void {
    this.routeData.unsubscribe();
  }

  loadAll() {
    this.customerService.query( {
      page: this.page -1,
      size: this.itemsPerPage,
      sort: this.sort()
    }).subscribe(
      (res: HttpResponse<Customer[]>) => this.onSuccess(res.body, res.headers),
      (res: HttpResponse<any>) => this.onError(res.body)
    );
  }

  sort() {
    const result = [this.predicate + ',' + (this.reverse ? 'asc' : 'desc')];
    if (this.predicate !== 'id') {
      result.push('id');
    }
    return result;
  }

  private onSuccess(data, headers) {
    this.links = this.parseLinks.parse(headers.get('link'));
    this.totalItems = headers.get('X-Total-Count');
    this.queryCount = this.totalItems;
    this.customers = data;
  }

  private onError(error) {
    console.log(error.message);
  }
}
