import { JsonPipe } from '@angular/common';
import { Component, Input, OnInit } from '@angular/core';


@Component({
  selector: 'app-table-emargement',
  templateUrl: './table-emargement.component.html',
  styleUrls: ['./table-emargement.component.scss']
})
export class TableEmargementComponent implements OnInit {
  @Input()
  stagiaires!:any;

  @Input()
  time!: string;


  constructor() { 
//  *ngFor="let stagiaire of stagiaires"


  }

  ngOnInit(): void {
   // alert("time"+this.time);
  }

}
