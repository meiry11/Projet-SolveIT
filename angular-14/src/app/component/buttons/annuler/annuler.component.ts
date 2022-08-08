import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-annuler',
  templateUrl: './annuler.component.html',
  styleUrls: ['./annuler.component.scss']
})
export class AnnulerComponent implements OnInit {
  @Input()
  chemin: string="";
  buttondata: any = 
    {
      btn: "Annuler",
      icon: "fa-check"
    };

  model = {
    left: true,
    middle: false,
    right: false,
  };
  constructor() { }

  ngOnInit(): void {
  }

}
