import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { dateSelectionJoinTransformer } from '@fullcalendar/core';


@Component({
  selector: 'app-page1',
  templateUrl: './page1.component.html',
  styleUrls: ['./page1.component.scss']
})
export class Page1Component implements OnInit {

  @Output()
  onAddStagiaireEvent:EventEmitter<any> = new EventEmitter();
  
  session!:any;

  stagiaire!: any;

  codeOrga!: string;
  nSession!: string;
  dateEntre!: string;
  dateSortie!: string;
  mr!: string;
  nom!: string;
  prenom!: string;
  datenaissance!:string;
  nss!: string;
  nomnaissance!: string;
  paysnaiss!: string;
  adress1!: string;
  cp!: string;
  ville!: string;
  tel!:string
  email!: string;
  diplome!: string;
  HF!: string;
  derniereClasse!: string;
  niveauFormation!: string;
  diffiulte!: string;
  
  



  



  constructor() { }

  
  
  
  ngOnInit(): void {

    
  }

  onChange(){
    
    this.stagiaire.numSecu = this.nss;
    this.stagiaire.nom = this.nom;
    this.stagiaire.prenom = this.prenom;
    this.stagiaire.datenaissance = this.datenaissance;
    this.stagiaire.adress1 = this.adress1;
    this.stagiaire.civilite = this.mr;
    this.stagiaire.diplome = this.diplome;
    this.stagiaire.niveau_entree = this.niveauFormation;

    if( this.diffiulte == "Oui" ){
      this.stagiaire.diffiulte = true;
    } else {
      this.stagiaire = false;
    }
    
    this.stagiaire.handicape = false;
    this.session.libelle = this.nSession;
    this.session.date_debut = this.dateEntre;
    this.session.date_fin = this.dateSortie;

  }

  onSubmit(){
   
    this.onAddStagiaireEvent.emit(this.stagiaire.value);

  }


}
