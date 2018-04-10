import { Component, OnInit } from '@angular/core';
import {Company} from "../model/company.model";
import {Router} from "@angular/router";
import {CompanyService} from "./company.service";

@Component({
  selector: 'app-company',
  templateUrl: './company.component.html',
  styleUrls: ['./company.component.css']
})
export class CompanyComponent implements OnInit {

  companies: Company[];
  constructor(private router: Router, private companyService: CompanyService) { }

  ngOnInit() {
    this.companyService.getCompanies()
      .subscribe( data => {
        this.companies = data;
      })
  }

  deleteCompany(company: Company): void {
    this.companyService.deleteCompany(company)
      .subscribe( data => {
        this.companies = this.companies.filter( c => c!== company);
      })
  }

}
