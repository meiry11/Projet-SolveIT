import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-generic-alert-button',
  templateUrl: './generic-alert-button.component.html',
  styleUrls: ['./generic-alert-button.component.scss']
})
export class GenericAlertButtonComponent implements OnInit {
  @Input()
  buttonTitle!: string;

  @Input()
  alertMessage!: string;

  constructor() { }

  ngOnInit(): void {
  }

  onClick(){
    alert(this.alertMessage);
  }

}
