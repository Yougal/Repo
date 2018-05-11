import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs/BehaviorSubject';
@Injectable()
export class DataService {

  private categories =  new BehaviorSubject<any>(['Sports','News','Bollywood']);
  
  catObs;
  
  constructor() { 
   this.catObs=this.categories.asObservable();
  }

  changeCat(cat){
    this.categories.next(cat);
  }
  
}
