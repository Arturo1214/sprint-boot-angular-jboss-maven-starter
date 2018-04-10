import {Injectable} from "@angular/core";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Company} from "../model/company.model";

const httpOptions = {
  headres: new HttpHeaders({'Content-Type': 'application/json'})
};

@Injectable()
export class CompanyService {

  constructor(private  http:HttpClient) {}

  private companyUrl = '/server/api/companies';

  public getCompanies() {
    return this.http.get<Company[]>(this.companyUrl);
  }

  public createCompany(company) {
    return this.http.post<Company>(this.companyUrl, company);
  }

  public deleteCompany(company) {
    return this.http.delete(this.companyUrl + "/" + company.id);
  }

}
