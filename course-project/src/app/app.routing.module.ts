import { AppComponent } from './app.component';
import { RecipeDetailComponent } from './recipes/recipe-detail/recipe-detail.component';
import { RecipeEditComponent } from './recipes/recipe-edit/recipe-edit.component';
import { RecipeStartComponent } from './recipes/recipe-start/recipe-start.component';
import { RecipesComponent } from './recipes/recipes.component';
import { ShoppingListComponent } from './shopping-list/shopping-list.component';
import { NgModule } from '@angular/core';
import { Route, RouterModule } from '@angular/router';


const appRoutes : Route[]=[
      {path:'',component:RecipesComponent,pathMatch:'full'},
      {path:'recipes',component:RecipesComponent,children:[
          {path:'',component:RecipeStartComponent},
          {path:'new',component:RecipeEditComponent},
          {path:':id',component:RecipeDetailComponent},
          {path:':id/edit',component:RecipeEditComponent}
      ]},
      {path:'shoppingList',component:ShoppingListComponent},
];

@NgModule({ 
  imports: [
    RouterModule.forRoot(appRoutes)
  ],
  exports:[RouterModule]
})
export class AppRoutingModule { }
