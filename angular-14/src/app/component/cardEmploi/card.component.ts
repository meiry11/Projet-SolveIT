import { Component } from '@angular/core';
import { SessionService } from '../../services/session/session.service';
@Component({
  templateUrl: 'card.component.html'
})
export class CardEmploiComponent {
  sessionList?:any[];

  constructor(private service: SessionService) { }
  ngOnInit(): void {

    this.service.findAllSessions()
    .subscribe(data=>this.sessionList = data);

    
    // .subscribe((data)=>this.productList = data);
  }
  showData(){
    alert(JSON.stringify(this.sessionList));
  }


}
