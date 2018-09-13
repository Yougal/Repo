  import { Ingredient } from '../../shared/ingredient.model';
import { ShoppinglistService } from '../shoppinglist.service';
import { Component, OnInit, ElementRef, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-shopping-edit',
  templateUrl: './shopping-edit.component.html',
  styleUrls: ['./shopping-edit.component.css'],
})
export class ShoppingEditComponent implements OnInit {

  constructor(private shoppinglistService:ShoppinglistService) { }

  ngOnInit() {
  }

  addNewIngredient(inputName,inputAmount){
    this.shoppinglistService.addNew({'name': inputName.value,'amount': inputAmount.value===''?0:inputAmount.value});
  }  
}
