import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-alert-button',
  templateUrl: './alert-button.component.html',
  styleUrls: ['./alert-button.component.scss']
})
export class AlertButtonComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  onClick(){
    alert("tu as cliquez sur le boutton");
  }

}
