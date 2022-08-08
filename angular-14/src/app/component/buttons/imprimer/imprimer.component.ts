import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-imprimer',
  templateUrl: './imprimer.component.html',
  styleUrls: ['./imprimer.component.scss']
})
export class ImprimerComponent implements OnInit {
  buttondata: any = 
  {
    btn: "Imprimer",
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
