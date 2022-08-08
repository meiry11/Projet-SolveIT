import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { SessionService } from '../../services/session/session.service';

import {Observable} from 'rxjs';
import {map, startWith} from 'rxjs/operators';
import { environment } from '../../../environments/environment';
import { StagiaireService } from '../../services/stagiaire/stagiaire.service';
import { FeuilleEmargementService } from '../../services/feuilleEmargement/feuille-emargement.service';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { data } from 'jquery';

const apiUrlStagiaire = environment.API_URL+"/session"

@Component({
  selector: 'app-formulaire-emargement',
  templateUrl: './formulaire-emargement.component.html',
  styleUrls: ['./formulaire-emargement.component.scss']
})
export class FormulaireEmargementComponent implements OnInit {
  temps!:string;
  chemin:string="/component/card";
  myControl = new FormControl('');
  options: any[] = [];
  filteredOptions!: Observable<string[]>;
  selectedOption:string="";
  dateDForm:string="";
  dateFForm:string="";
  stagiaires:any= "";
  feuilleEmarg!:any;
  feuilleEmar!:any;

  numero:string="";
  intitule:string="";
  lieu:string="";
  dateE:string="";

  constructor(private route: ActivatedRoute,
    private router: Router,private sessionService:SessionService,private stagiaireService:StagiaireService,private feuilleEmargementService: FeuilleEmargementService) { }

  ngOnInit(): void {
    

    this.sessionService.findAllSessions().subscribe((data)=> this.options = data);
    const num= this.route.snapshot.paramMap.get('num');
       
    if(num){
      this.feuilleEmar = this.feuilleEmargementService.findById(num).subscribe((data: any)=> this.feuilleEmar=data);
      if(this.feuilleEmar != null){
        this.numero=JSON.stringify(this.feuilleEmar.num);
      }
     
    }  
  }

  onChange(){
    if((this.selectedOption != "") && (this.dateDForm != "") && (this.dateFForm != "")){
      this.stagiaireService.findBySession(this.selectedOption,this.dateDForm,this.dateFForm).subscribe((data)=> this.stagiaires=data);
    }
  }

  onSubmit(){
    if(  this.numero !="" && this.intitule !="" && this.lieu !="" && this.dateE !=""){
      this.feuilleEmarg={
        "num" : this.numero,
        "intitule" : this.intitule,
        "lieu" : this.lieu,
        "date_emargement" : this.dateE,
        "date_debut_formation" : this.dateDForm,
        "date_fin_formation" : this.dateFForm
      }
      this.feuilleEmargementService.save(this.feuilleEmarg).subscribe();
      }
      
   
  }
  printPage() {
    window.print();
  }


}
