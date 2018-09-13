import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LoggingService {

  constructor() { }


  logStatusChanged(accountStatus: String) {
     console.log('A server status changed, new status: ' + accountStatus);
  }
}
