import { Component, OnInit, Output, EventEmitter, Input } from '@angular/core';

@Component({
  selector: 'app-child',
  templateUrl: './child.component.html',
  styleUrls: ['./child.component.css']
})
export class ChildComponent implements OnInit {

  counterChild = 0;

  @Input() parentCounter;

  @Output() result = new EventEmitter<number>();


  constructor() { }

  ngOnInit() {
  }

  onClickChild() {
    this.counterChild++;
    this.result.emit(this.counterChild);
  }

}
