import { Component, OnInit } from '@angular/core';

import { ServersService } from '../servers.service';
import { CanDeactivateGaurd, CanComponentDeactivate } from './can-deactivate-gaurd.service';
import { ActivatedRoute, Params, RouteConfigLoadStart, Router, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-edit-server',
  templateUrl: './edit-server.component.html',
  styleUrls: ['./edit-server.component.css']
})
export class EditServerComponent implements OnInit, CanComponentDeactivate {
 
  server: {id: number, name: string, status: string};
  serverName = '';
  serverStatus = '';
  isAllowedToEdit:boolean = false;
  constructor(private serversService: ServersService, private route:ActivatedRoute, private router: Router) { }

  ngOnInit() {
    this.server = this.serversService.getServer(parseInt(this.route.snapshot.params['id']));
    this.serverName = this.server.name;
    this.serverStatus = this.server.status;
    this.route.params.subscribe((params: Params)=>this.server=this.serversService.getServer(parseInt(params['id'])));
    this.route.queryParams.subscribe((params: Params)=>{
       this.isAllowedToEdit=params['editAllowed']==1?true:false;
    });
  }

  onUpdateServer() {
    this.serversService.updateServer(this.server.id, {name: this.serverName, status: this.serverStatus});
    this.router.navigate(['../'],{relativeTo:this.route});
  }
  
   canDeactive(): boolean | Promise<boolean> | Observable<boolean> {
     if(this.isAllowedToEdit){
       if(this.server.name!==this.serverName || this.server.status!==this.serverStatus){
         return confirm(" Do you want to discard the changes");
       }else{
         return true;
       }
     }
     
   }

}
