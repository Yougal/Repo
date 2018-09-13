import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  private evenNumbers: number[];

  private oddNumbers: number[];

  onNumberIncrement(counter: number) {

    if (counter % 2 === 0) {
      this.evenNumbers.push(counter);
    } else {
      this.oddNumbers.push(counter);
    }
  }

  onGameStart() {
       this.evenNumbers = [];
       this.oddNumbers = [];
  }
}
