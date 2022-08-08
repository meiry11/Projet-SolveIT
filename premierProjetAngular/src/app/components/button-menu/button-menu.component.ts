import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-button-menu',
  templateUrl: './button-menu.component.html',
  styleUrls: ['./button-menu.component.scss']
})
export class ButtonMenuComponent implements OnInit {
  buttons: any=[
    {
      buttonTitle: 'Philips !',
      alertMessage: 'Je sais ou tu te cache !'
    },
    {
      buttonTitle: 'Marcooo !',
      alertMessage: 'Polo !'
    },
    {
      buttonTitle: 'Toto !',
      alertMessage: 'Tata !'
    }
  ]
  constructor() { }

  ngOnInit(): void {
  }

}
