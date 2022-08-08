import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-enregistrer',
  templateUrl: './enregistrer.component.html',
  styleUrls: ['./enregistrer.component.scss']
})
export class EnregistrerComponent implements OnInit {
  buttondata: any = 
    {
      btn: "Enregistrer",
      icon: "fa-check"
    };

  model = {
    left: true,
    middle: false,
    right: false,
  };

  model1 = 1;

  constructor() { }

  ngOnInit(): void {
  }

}
