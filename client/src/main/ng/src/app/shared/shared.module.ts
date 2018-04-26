import {CUSTOM_ELEMENTS_SCHEMA, NgModule} from "@angular/core";
import {ParseLinks} from "./service/ParseLinks";
import {SharedLibsModule} from "./shared-libs.module";
import {PaginationUtil} from "./service/PaginationUtil";

@NgModule({
  imports: [
    SharedLibsModule
  ],
  declarations: [],
  providers: [
    ParseLinks,
    PaginationUtil
  ],
  entryComponents: [],
  exports: [
    SharedLibsModule
  ],
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class SharedModule {}
