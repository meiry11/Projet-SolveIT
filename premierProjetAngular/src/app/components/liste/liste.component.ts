import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-liste',
  templateUrl: './liste.component.html',
  styleUrls: ['./liste.component.scss']
})
export class ListeComponent implements OnInit {

  prenoms: string[] = ["smith tom","smith caroline","smith james","smith gigi","smith jony"]

  constructor() { }

  ngOnInit(): void {
  }

}
