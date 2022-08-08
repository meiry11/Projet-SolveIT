import { Component, AfterViewInit, OnInit } from '@angular/core';
import { ROUTES } from './menu-items';
import { RouteInfo } from './sidebar.metadata';
import { Router, ActivatedRoute } from '@angular/router';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { StagiaireService } from '../../services/stagiaire/stagiaire.service';

//declare var $: any;

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html'
})
export class SidebarComponent implements OnInit {
  showMenu = '';
  showSubMenu = '';
  public sidebarnavItems:RouteInfo[]=[];
  persons!:any[];
  // this is for the open close
  addExpandClass(element: string) {
    if (element === this.showMenu) {
      this.showMenu = '0';
    } else {
      this.showMenu = element;
    }
  }

  constructor(
    private modalService: NgbModal,
    private router: Router,
    private route: ActivatedRoute,
    private stagiareService:StagiaireService
  ) {    this.stagiareService.findAll().subscribe((data) => this.persons = data);
  }


  // End open close
  ngOnInit() {
    this.sidebarnavItems = ROUTES.filter(sidebarnavItem => sidebarnavItem);
    this.stagiareService.findAll().subscribe((data) => this.persons = data);

  }
}
