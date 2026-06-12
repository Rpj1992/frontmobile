import { ApplicationConfig, provideBrowserGlobalErrorListeners } from '@angular/core';
import {HttpClient, provideHttpClient} from '@angular/common/http';
import {ReactiveFormsModule} from '@angular/forms';

export const appConfig: ApplicationConfig = {
  providers: [
    provideBrowserGlobalErrorListeners(),
    provideHttpClient(),
  ]
};
