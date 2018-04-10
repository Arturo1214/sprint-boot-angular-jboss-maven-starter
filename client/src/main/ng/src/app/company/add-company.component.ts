import {Component} from "@angular/core";
import {Company} from "../model/company.model";
import {Router} from "@angular/router";
import {CompanyService} from "./company.service";

@Component({
  templateUrl: './add-company.component.html'
})
export class AddCompanyComponent {
  company: Company = new Company();

  constructor(private router: Router, private companyService: CompanyService) {}

  createCompany(): void {
    this.companyService.createCompany(this.company)
      .subscribe( data => {
        alert("company created successfully.");
      })
  }
}
