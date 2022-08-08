import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { RouteInfo } from './sidebar.metadata';
import { ROUTES } from './menu-items';
import { StagiaireService } from '../../services/stagiaire/stagiaire.service';



@Injectable({
    providedIn: 'root'
})
export class VerticalSidebarService {

    public screenWidth: any;
    public collapseSidebar: boolean = false;
    public fullScreen: boolean = false;
    persons!:any[];
    MENUITEMS: RouteInfo[] = ROUTES;

    items = new BehaviorSubject<RouteInfo[]>(this.MENUITEMS);

    constructor(private stagiareService:StagiaireService) {
        this.stagiareService.findAll().subscribe((data) => this.persons = data);

    }
    
}
