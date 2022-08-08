import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.scss']
})
export class UserComponent implements OnInit {
  nom: string ='Francois';
  prenom: string= 'Claude';
  urlimage: string= '../assets/24308_tz9f.jpg';
  job: string="";

  constructor() { }

  ngOnInit(): void {
  }

}
