import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-liste-filtre',
  templateUrl: './liste-filtre.component.html',
  styleUrls: ['./liste-filtre.component.scss']
})
export class ListeFiltreComponent implements OnInit {
  personnes : string[] =["smith tom","smith caroline","smith james","smith gigi","smith jony"]
  constructor() { }

  ngOnInit(): void {
  }

}
