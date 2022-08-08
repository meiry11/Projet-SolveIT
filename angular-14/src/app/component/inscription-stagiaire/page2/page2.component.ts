import { JsonPipe } from '@angular/common';
import { Component, Input, OnInit } from '@angular/core';
import { Compte } from '../../../models/compte.model';
import { CompteService } from '../../../services/compte/compte.service';
import { HebergementService} from'../../../services/hebergement/hebergement.service';

@Component({
  selector: 'app-page2',
  templateUrl: './page2.component.html',
  styleUrls: ['./page2.component.scss']
})
export class Page2Component implements OnInit {
  selectedRadio!:string;
  DOM!:string;
  Vivez!:string;
  foyer!:string;
  enfants!:string;
  parents!:string;
  logement!:string;
  perdrelogement!:string;
  temps_trajet!:string;
  structureSelect!:string;
  transportSelect!:string;
  hebergementSelect!:string;
  allocationSelect!:string;
  situation!:string;
  Emploi!:string;
  num_inscription!:string;
  IndemnisationPole!:string;
  temps_sans_emploi!:string;
  categorieSelect!:string;
  type_contratSelect!:string;
  tempsTravailtSelect!:string;

  
  stagiaire!:any;
  situationProf!:any;


  hidden: boolean=true;
  hide: boolean=true;
  hidde: boolean=true;
  hidd: boolean=true;
  type_contrat:any[]=[
    {
      "value": ""
    },
    {
      "value": "CDI"
    },
    {
      "value": "CDD"
    },
    {
      "value": "CDDI d'Insertion"
    },
    {
      "value": "Contrats aidés secteur non marchand"
    },
    {
      "value": "Contrats aidés secteur marchand"
    },
    {
      "value": "Autres contrats aidés"
    }
  ];
  categories:any[]=[
    {
      "value": ""
    },
    {
      "value": "Ouvrier non qualifié"
    },
    {
      "value": "Ouvrier qualifié"
    },
    {
      "value": "Employé non qualifié"
    },
    {
      "value": "Employé qualifié"
    },
    {
      "value": "Technicien Agent de Maitrise"
    },
    {
      "value": "Cadre"
    }
  ];
  allocataires:any[]=[
    {
      "value": ""
    },
    {
      "value": "RSA - Revenu de Solidarité Active"
    },
    {
      "value": "ASS - Allocation Spécifique de Solidarité"
    },
    {
      "value": "AAH - Allocation Adulte Handicapé"
    },
    {
      "value": "Non"
    }
  ];
  hebergements!:any[];
  transports: any[]=[
    {
      "value": ""
    },
    {
      "value": "A PIED – A VELO"
    },
    {
      "value": "BUS – TRAMWAY - METRO"
    },
    {
      "value": "VOITURE – 2 ROUES MOTORISEES"
    },
    {
      "value": "TRAIN"
    }
  ];
  structures: any[]=[
    {
      "value": ""
    },
    {
      "value": "APEC"
    },
    {
      "value": "Association d’insertion sociale"
    },
    {
      "value": "Cap Emploi"
    },
    {
      "value": "CCAS ou UTPAS"
    },
    {
      "value": "Opérateur compétences clés"
    },
    {
      "value": "Démarche personnelle"
    },
    {
      "value": "Espace Info Formation"
    },
    {
      "value": "Jury post VAE"
    },
    {
      "value": "Missions Locales"
    },
    {
      "value": "Conseil Départemental"
    },
    {
      "value": "OPACIF"
    },
    {
      "value": "Organisme de formation"
    },
    {
      "value": "PLIE - MDE"
    },
    {
      "value": "Pôle Emploi"
    },
    {
      "value": "Proch'Emploi"
    },
    {
      "value": "Structure d'insertion par l'activité économique"
    },
    {
      "value": "◻Universités"
    },
    {
      "value": "Agents Région (hors Proch'Emploi)"
    },
    {
      "value": "EPIDE Etablissement pour l'insertion dans l'emploi"
    },
    {
      "value": "Ecole de la 2ème chance"
    }
  ];

  constructor(private serviceHebergement:HebergementService,private serviceCompte:CompteService) {
    //this.serviceHebergement.findAll().subscribe((data)=> this.hebergements =data);
    this.serviceHebergement.findAll().subscribe((data)=> this.hebergements = data);
  }

  ngOnInit(): void {
    

  }
  toggle(){
      this.hidden= false;
      this.hide=true
  }
  init(){
    this.hide= true;
    this.hidden= true;
  }

  togglehide(){
    this.hide= false;
    this.hidden= true;
  }
  toggl(){
    this.hidde= false;
    this.hidd=true
  }
  togglhide(){
    this.hidd= false;
    this.hidde= true;
  }

  onChange(){
    this.stagiaire.domtom = this.DOM;
    this.stagiaire.situation = this.Vivez;
    this.stagiaire.nbr_travailleur = this.foyer;
    if(this.enfants == "Oui"){
      this.stagiaire.enfant = true;
    }else{
      this.stagiaire.enfant = false;
    }
    this.stagiaire.parent_francais = this.parents;
    this.stagiaire.logement = this.logement;
    if(this.perdrelogement == "Oui"){
    this.stagiaire.rique_perte_logement = true;
    }else{
      this.stagiaire.rique_perte_logement = false;
    }
   
    this.stagiaire.origine_formation = this.structureSelect;
    this.stagiaire.transport = this.transportSelect;

    this.stagiaire.hebergement = this.hebergementSelect;

    
    this.stagiaire.allocation = this.allocationSelect;

    if( this.situation == "salarie"){
      this.situationProf.salarie =true;
    }else{
      this.situationProf.salarie =false;
    }
    if(this.situation == "demandeur"){
    this.situationProf.demandeur_emploi =true;
    }else{
      this.situationProf.demandeur_emploi =false;
    }
    if(this.Emploi == "demandeur"){
      this.situationProf.Inscrit =true;
      }else{
        this.situationProf.Inscrit =false;
      }
  }

}
