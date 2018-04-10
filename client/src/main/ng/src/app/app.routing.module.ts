import {RouterModule, Routes} from "@angular/router";
import {CompanyComponent} from "./company/company.component";
import {AddCompanyComponent} from "./company/add-company.component";
import {AppComponent} from "./app.component";
import {NgModule} from "@angular/core";

const routes: Routes = [
  { path: '', redirectTo: '/', pathMatch: 'full'},
  { path : 'companies', component: CompanyComponent},
  { path : 'add', component: AddCompanyComponent}
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [
    RouterModule
  ],
  declarations: []
})
export class AppRoutingModule {}
