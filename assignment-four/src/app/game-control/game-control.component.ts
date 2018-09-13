import { Component, OnInit, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-game-control',
  templateUrl: './game-control.component.html',
  styleUrls: ['./game-control.component.css']
})
export class GameControlComponent implements OnInit {

  @Output() private numberIncrement: EventEmitter<number>  =  new EventEmitter<number>();
  @Output() private gameStart: EventEmitter<boolean>  =  new EventEmitter<boolean>();
  private ref;
  private counter = 0;
  private gameStarted = false;
  constructor() { }

  ngOnInit() {
  }

  startGame() {
   this.ref = setInterval(() => {
      this.numberIncrement.emit(this.counter++);
    }, 1000);
    this.gameStarted = true;
    this.gameStart.emit(true);
  }

  stopGame() {
     clearInterval(this.ref);
     this.counter = 0;
     this.gameStarted = false;
  }

}
