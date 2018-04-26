import {SERVER_API_URL} from "../../app.constants";
import {HttpClient, HttpResponse} from "@angular/common/http";
import {Customer} from "./customer.model";
import {Observable} from "rxjs/Observable";
import {createRequestOption} from "../../shared/model/request-util";
import {Injectable} from "@angular/core";

@Injectable()
export class CustomerService {
  private resourceUrl = SERVER_API_URL + 'api/customers';

  constructor(private http: HttpClient) {}

  create(customer: Customer): Observable<HttpResponse<Customer>> {
    return this.http.post<Customer>(this.resourceUrl, customer, { observe: 'response' });
  }

  update(customer: Customer): Observable<HttpResponse<Customer>> {
    return this.http.put<Customer>(this.resourceUrl, customer, { observe: 'response' });
  }

  find(id: number): Observable<HttpResponse<Customer>> {
    return this.http.get<Customer>(`${this.resourceUrl}/${id}`, { observe : 'response' });
  }

  query(req?: any): Observable<HttpResponse<Customer[]>> {
    const options = createRequestOption(req);
    return this.http.get<Customer[]>(this.resourceUrl, { params: options, observe: 'response'});
  }

  delete(id: number): Observable<HttpResponse<any>> {
    return this.http.delete(`${this.resourceUrl}/${id}`, { observe: 'response'});
  }
}
