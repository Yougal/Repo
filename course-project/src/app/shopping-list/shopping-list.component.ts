import { Ingredient } from '../shared/ingredient.model';
import { ShoppinglistService } from './shoppinglist.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-shopping-list',
  templateUrl: './shopping-list.component.html',
  styleUrls: ['./shopping-list.component.css'],
})
export class ShoppingListComponent implements OnInit {

  private ingredients: Ingredient[];
  
  constructor(private shoppinglistService:ShoppinglistService) { }

  ngOnInit() {
    this.ingredients=this.shoppinglistService.getIngredients();
    this.shoppinglistService.newIngAddEvent.subscribe(()=>{
      this.ingredients=this.shoppinglistService.getIngredients();
    });
  }

}
