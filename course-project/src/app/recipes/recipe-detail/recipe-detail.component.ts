import { Ingredient } from '../../shared/ingredient.model';
import { ShoppinglistService } from '../../shopping-list/shoppinglist.service';
import { Recipe } from '../recipe.model';
import { RecipeService } from '../recipe.service';
import { Component, OnInit, Input } from '@angular/core';
import { ActivatedRouteSnapshot, ActivatedRoute, Data, Params, Router } from '@angular/router';

@Component({
  selector: 'app-recipe-detail',
  templateUrl: './recipe-detail.component.html',
  styleUrls: ['./recipe-detail.component.css']
})
export class RecipeDetailComponent implements OnInit {
  private id: number;
  private recipe: Recipe;
  
  constructor(
    private recipeService : RecipeService,
    private shoppinglistService:ShoppinglistService, private route: ActivatedRoute, private router: Router) { }

  ngOnInit() {
    this.route.params.subscribe(
      (params:Params)=>{
          this.recipe = this.recipeService.getRecipe(+params['id']);
          this.id = +params['id'];
      }
    );
    
  }
  
  addToShoppingList(){
    for(let ingredient of this.recipe.ingredients){
       this.shoppinglistService.addNew(ingredient);
    }
  }
  
  onEditRecipe(){
    this.router.navigate(['edit'],{relativeTo:this.route});
  }

}
