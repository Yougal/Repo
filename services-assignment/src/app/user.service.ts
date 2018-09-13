import { Injectable, Output, EventEmitter } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  activeUsers = ['Max', 'Anna'];
  inactiveUsers = ['Chris', 'Manu'];
  
  @Output() userSetToActive = new EventEmitter<number>();
  @Output() userSetToInactive = new EventEmitter<number>();
  
  constructor() { }
  
  onSetToActive(id: number) {
    this.userSetToActive.emit(id);
  }
  
  onSetToInActive(id: number) {
    this.userSetToInactive.emit(id);
  }
  
}
