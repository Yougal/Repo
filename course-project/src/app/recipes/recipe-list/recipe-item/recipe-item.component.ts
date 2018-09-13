import { Recipe } from '../../recipe.model';
import { RecipeService } from '../../recipe.service';
import { Component, Input} from '@angular/core';

@Component({
  selector: 'app-recipe-item',
  templateUrl: './recipe-item.component.html',
  styleUrls: ['./recipe-item.component.css']
})
export class RecipeItemComponent{

  @Input() private recipe :Recipe;
  
  @Input() private index: number;
  
}
