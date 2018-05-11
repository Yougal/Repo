import { Component, OnInit, Input, Output, OnChanges, SimpleChanges } from '@angular/core';

@Component({
  selector: 'app-parent',
  templateUrl: './parent.component.html',
  styleUrls: ['./parent.component.css']
})
export class ParentComponent implements OnInit, OnChanges {

  parentCounter = 0;
  @Output() childCounter;

  constructor() { }

  ngOnInit() {
  }

  onClickParent() {
  this.parentCounter++;
  }

   ngOnChanges(changes: SimpleChanges): void {
    this.childCounter = changes;
  }

}
