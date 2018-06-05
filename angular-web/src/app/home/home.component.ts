import { Component, OnInit } from '@angular/core';
import { trigger, style, transition, animate, keyframes, query, stagger } from '@angular/animations';
import { DataService } from '../data.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
  animations: [
      trigger('cats', [
            transition('* => *', [

              query(':enter', style({ opacity: 0 }), {optional: true}),

              query(':enter', stagger('300ms', [
                animate('.6s ease-in', keyframes([
                  style({opacity: 0, transform: 'translateY(-75%)', offset: 0}),
                  style({opacity: .5, transform: 'translateY(35px)',  offset: 0.3}),
                  style({opacity: 1, transform: 'translateY(0)',     offset: 1.0}),
                ]))]), {optional: true}),
              
              query(':leave', stagger('300ms', [
                animate('.6s ease-in', keyframes([
                  style({opacity: 1, transform: 'translateY(0)', offset: 0}),
                  style({opacity: .5, transform: 'translateY(35px)',  offset: 0.3}),
                  style({opacity: 0, transform: 'translateY(-75%)',     offset: 1.0}),
                ]))]), {optional: true})
            ])
          ])
  ]
})
export class HomeComponent implements OnInit {

  itemCount: number;
  btnTxt = 'Add a Category';
  catTxt: string;

  cat: string[] = [];
  constructor(private dataService : DataService) { }

  ngOnInit() {
    this.dataService.catObs.subscribe(res => this.cat = res);
    this.itemCount = this.cat.length;
    this.dataService.changeCat(this.cat);
  }

  addItem(): void {
    this.cat.push(this.catTxt);
    this.catTxt = '';
    this.itemCount = this.cat.length;
    this.dataService.changeCat(this.cat);
  }

  removeItem(index: number) {
    this.cat.splice(index, 1);
    this.itemCount = this.cat.length;
    this.dataService.changeCat(this.cat);
  }

}
