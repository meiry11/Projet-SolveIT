import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-seconde-component',
  template: '<div>je suis mauvaise pratique </div>',
  styles: [`div{
    color: blue;
    background-color: pink;
  }`]
})
export class SecondeComponentComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

}
