import { Component, OnInit, EventEmitter, Output } from '@angular/core';

@Component({
  selector: 'app-cockpit',
  templateUrl: './cockpit.component.html',
  styleUrls: ['./cockpit.component.css']
})
export class CockpitComponent implements OnInit {
  @Output() serverCreated = new EventEmitter<{ name: string, type: string, serverContent: string}>();
  newServerName = '';
  newServerContent = '';
  
  constructor() { }

  ngOnInit() {
  }
  
  onAddServer() {
   this.serverCreated.emit({name: this.newServerName, type: 'server', serverContent: this.newServerContent});
  }

  onAddBlueprint() {
    this.serverCreated.emit({name: this.newServerName, type: 'blueprint', serverContent: this.newServerContent});
  }

}
