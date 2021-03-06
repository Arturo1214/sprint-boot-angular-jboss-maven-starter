import {NgModule} from "@angular/core";
import {NgbModule} from "@ng-bootstrap/ng-bootstrap";
import {FormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";
import {CommonModule} from "@angular/common";

@NgModule({
  imports: [
    NgbModule.forRoot(),
  ],
  exports: [
    FormsModule,
    HttpClientModule,
    CommonModule,
    NgbModule
  ]
})
export class SharedLibsModule {}
