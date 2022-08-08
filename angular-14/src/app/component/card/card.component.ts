import { Component, Input, OnInit, Output } from '@angular/core';
import { FeuilleEmargementService } from '../../services/feuilleEmargement/feuille-emargement.service';
import { environment } from '../../../environments/environment';
@Component({
  templateUrl: 'card.component.html'
})
export class CardsComponent implements OnInit{
  
  chemin:string="/component/NouvelleFeuille";
  @Output()
  feuilles: any[]=[];

  apiUrl:string="";
  constructor(private feuilleService:FeuilleEmargementService){
    this.feuilleService.findAll().subscribe(data=>this.feuilles = data);
  }
  ngOnInit(): void {
     this.apiUrl = environment.API_URL+"/feuilleemargements";

     this.feuilleService.findAll().subscribe(data=>this.feuilles = data);
     
  }

  updateDelete(feuilles : any){
    this.feuilles = feuilles;
  }
}
