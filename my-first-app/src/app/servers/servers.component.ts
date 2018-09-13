import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-servers',
  templateUrl: './servers.component.html',
  styleUrls: ['./servers.component.css']
})
export class ServersComponent implements OnInit {

  allowToAddNewServer = false;
  serverCreationStatus = 'No server is created';
  serverCreated = false;
  serverName = '';
  private servers = ['Server-1', 'Server-2'];
  constructor() {

    setTimeout(() => {
      this.allowToAddNewServer = true;
    }, 2000);
  }

  ngOnInit() {
  }

  onCreateServer() {
    this.serverCreated = true;
    this.servers.push(this.serverName);
    this.serverName = '';
  }

  onUpdateServerName(event: Event) {
    this.serverName = (<HTMLInputElement>event.target).value;
  }

}
