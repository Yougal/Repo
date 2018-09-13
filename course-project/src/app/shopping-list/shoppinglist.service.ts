import { Ingredient } from '../shared/ingredient.model';
import { Injectable, EventEmitter } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ShoppinglistService {

  newIngAddEvent: EventEmitter<void> = new EventEmitter<void>(); 
  
  private  ingredients: Ingredient[] = [
    new Ingredient('Apples',5),
    new Ingredient('Tomatoes',4)
  ];
  
  
  constructor() { }
  
  getIngredients(){
    return this.ingredients.slice();
  }
  
  addNew(ingredient:Ingredient){
    this.ingredients.push(ingredient);
    this.newIngAddEvent.emit();
  }
  
}
