import { AuthGaurd } from './auth-guard.service';
import { NgModule } from '@angular/core';

import { HomeComponent } from './home/home.component';
import { UsersComponent } from './users/users.component';
import { ServersComponent } from './servers/servers.component';
import { UserComponent } from './users/user/user.component';
import { EditServerComponent } from './servers/edit-server/edit-server.component';
import { ServerComponent } from './servers/server/server.component';
import { Route, RouterModule } from '@angular/router';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { CanDeactivateGaurd } from './servers/edit-server/can-deactivate-gaurd.service';

const appRoutes : Route[]=[
      {path:'',component:HomeComponent},
      {path:'users',component:UsersComponent,children:[
        {path:':id/:name',component:UserComponent}
      ]},
      {path:'servers',component:ServersComponent, /*canActivate:[AuthGaurd]*/
        canActivateChild:[AuthGaurd]
        ,children:[
        {path:':id',component:ServerComponent},
        {path:':id/edit',component:EditServerComponent,canDeactivate:[CanDeactivateGaurd]}
      ]},
      {path:'**',component:PageNotFoundComponent}
];

@NgModule({
  imports: [
    RouterModule.forRoot(appRoutes)
  ],
  exports:[RouterModule]
})
export class AppRoutingModule { }
