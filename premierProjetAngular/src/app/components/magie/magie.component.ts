import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-magie',
  templateUrl: './magie.component.html',
  styleUrls: ['./magie.component.scss']
})
export class MagieComponent implements OnInit {
  hidden: boolean=true;
  constructor() { }

  ngOnInit(): void {
  }
  toggle(){
    this.hidden= !this.hidden;
  }
  

}
