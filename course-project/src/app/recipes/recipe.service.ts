import { Ingredient } from '../shared/ingredient.model';
import { Recipe } from './recipe.model';
import { Injectable, EventEmitter } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class RecipeService {
  
  public recipeSelectedEvent:EventEmitter<Recipe> = new EventEmitter<Recipe>();
  
  private recipes: Recipe[] = [
    new Recipe(
      'Chicken Schnitzel',
      'Chicken Schnitzel is a popular and tasty treat served throughout Israel. Schnitzel is Austrian in origin; it was traditionally made with veal (known as Wiener Schnitzel) or pork. The dish later found its way to Israel with European Jewish immigrants. Like many Jewish foods, immigrants adapted this regional dish to suit their unique dietary kosher laws. In the case of schnitzel, pork (which is treif) and veal (which was expensive and difficult to obtain) was replaced by chicken and turkey. The result is a tasty treat that can be found in nearly every restaurant in Israel.',
      'https://toriavey.com/images/2011/02/IMG_1544.jpg',
      [
          new Ingredient('Meat',1),
          new Ingredient('French Fries',20),
          new Ingredient('Coke',1),
      ]),
    new Recipe('Big Burger Recipes',
      'Stars love customizing the classic beef Fatburger: Jay Leno takes his with a triple patty. Milla Jovovich prefers her toppings sandwiched between patties in place of a bun. But some Fatburger fans take their obsession to the next level: Queen Latifah, Kanye West and Pharrell Williams have each owned franchises',
      'https://food.fnr.sndimg.com/content/dam/images/food/fullset/2015/5/5/0/FNM_060115-Fatbuger-Recipe_s4x3.jpg.rend.hgtvcom.616.462.suffix/1431449537270.jpeg',
      [
          new Ingredient('Buns',2),
          new Ingredient('Meats',1),
      ])
  ];
  
  getRecipes(){
    return this.recipes.slice();
  }
  
  getRecipe(index :number){
    return this.recipes[index];
  }
  
  constructor() { }
  
}
