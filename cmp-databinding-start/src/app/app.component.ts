import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  serverElements = [{type: 'server', name: 'Test Server' , content: 'Just a test!'}];

  onServerAdded(serverData: { name: string, type: string, serverContent: string}) {
     this.serverElements.push({
      type: serverData.type,
      name: serverData.name,
      content: serverData.serverContent
    });
  }
}
