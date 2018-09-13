import { UserService } from './user.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  providers:[UserService]
})
export class AppComponent implements OnInit {
  
 
  constructor(private userService :UserService){}
 
   ngOnInit(): void {
     this.userService.userSetToActive.subscribe((id: number) => {this.userService.activeUsers.push(this.userService.inactiveUsers[id]);this.userService.inactiveUsers.splice(id, 1)});
     this.userService.userSetToInactive.subscribe((id: number) =>{this.userService.inactiveUsers.push(this.userService.activeUsers[id]);this.userService.activeUsers.splice(id, 1)});
   }
  

}
