import { AlertComponent } from './alert/alert.component';
import { SuccessComponent } from './alert/success/success.component';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { WarningComponent } from './alert/warning/warning.component';

@NgModule({
  declarations: [
    AppComponent,
    WarningComponent,
    SuccessComponent,
    AlertComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
