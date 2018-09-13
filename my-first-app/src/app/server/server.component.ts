import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-server',
  templateUrl: './server.component.html',
  styleUrls: ['./server.component.css']
})
export class ServerComponent implements OnInit {

  private serverId = '10';
  private serverStatus = 'offline';
  constructor() {
    this.serverStatus = Math.random() > 0.5 ? "Online" : "Offline";
  }

  ngOnInit() {
  }

  get status() {
    return this.serverStatus;
  }

}
