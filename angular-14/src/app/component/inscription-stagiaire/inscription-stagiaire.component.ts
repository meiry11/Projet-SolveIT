import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { StagiaireService } from '../../services/stagiaire/stagiaire.service';
import { CompteService } from '../../services/compte/compte.service';
import { HebergementService } from '../../services/hebergement/hebergement.service';
import { Stagiaire } from '../../models/stagiaire.models';

@Component({
  selector: 'app-inscription-stagiaire',
  templateUrl: './inscription-stagiaire.component.html',
  styleUrls: ['./inscription-stagiaire.component.scss'],
})
export class InscriptionStagiaireComponent implements OnInit {

  dden: boolean = false;
  session!: any;



  codeOrga!: string;
  nSession!: string;
  dateEntre!: string;
  dateSortie!: string;
  mr!: string;
  nom!: string;
  prenom!: string;
  datenaissance!: string;
  nss!: string;
  nomnaissance!: string;
  paysnaiss!: string;
  adress1!: string;
  cp!: string;
  ville!: string;
  tel!: string
  email!: string;
  diplome!: string;
  HF!: string;
  derniereClasse!: string;
  niveauFormation!: string;
  diffiulte!: string;

  selectedRadio!: string;
  DOM!: string;
  Vivez!: string;
  foyer!: string;
  enfants!: string;
  parents!: string;
  logement!: string;
  perdrelogement!: string;
  temps_trajet!: string;
  structureSelect!: string;
  transportSelect!: string;
  hebergementSelect!: string;
  allocationSelect!: string;
  situation!: string;
  Emploi!: string;
  num_inscription!: string;
  IndemnisationPole!: string;
  temps_sans_emploi!: string;
  categorieSelect!: string;
  type_contratSelect!: string;
  tempsTravailtSelect!: string;

  signature!: String;
  datesign!: String;
  stagiaire!: any;
  stagiaire1!: Stagiaire
  situationProf!: any;

  hidden: boolean = true;

  hide: boolean = true;
  hidde: boolean = true;
  hidd: boolean = true;
  type_contrat: any[] = [
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
  categories: any[] = [
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
  allocataires: any[] = [
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
  hebergements!: any[];
  transports: any[] = [
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
  structures: any[] = [
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

  constructor(private serviceHebergement: HebergementService, private serviceCompte: CompteService, private stagiaireService: StagiaireService) {
    //this.serviceHebergement.findAll().subscribe((data)=> this.hebergements =data);
    this.serviceHebergement.findAll().subscribe((data) => this.hebergements = data);
  }








  ngOnInit(): void {
  }

  onAddStagaire(stagiaire: any) {
    alert("c ok" + JSON.stringify(stagiaire.value))
  }

  printPage() {
    window.print();
  }


  toggle() {
    this.hidden = false;
    this.hide = true
  }
  init() {
    this.hide = true;
    this.hidden = true;
  }

  togglehide() {
    this.hide = false;
    this.hidden = true;
  }
  toggl() {
    this.hidde = false;
    this.hidd = true
  }
  togglhide() {
    this.hidd = false;
    this.hidde = true;
  }
  onSubmit() {
    this.stagiaire = {
      "numSecu": this.nss,
      "nom ": this.nom,
      "prenom": this.prenom,
      "datenaissance": new Date(this.datenaissance),
      "adresse": this.adress1,
      "civilite": this.mr,
      "diplome": this.diplome,
      "niveau_entree": this.niveauFormation,
      "diffiulte": (this.diffiulte == "Oui") ? true : false,
      "enfant": (this.enfants == "Oui") ? true : false,
      "parent_francais": this.parents,
      "logement": this.logement,
      "rique_perte_logement": (this.perdrelogement == "Oui") ? true : false,

      "origine_formation": this.structureSelect,
      "allocation": this.allocationSelect,

      "handicape": false,
      "libelle": this.nSession,
      "date_debut": this.dateEntre,
      "date_fin": this.dateSortie,
      "domtom": this.DOM,
      "situation": this.Vivez,
      "nbr_travailleur": this.foyer,
      "transport": this.transportSelect,
      "hebergement": this.hebergementSelect,


      "situationProfessionnelle": {
        "salarie": (this.situation == "salarie") ? true : false,
        "demandeur_emploi": (this.situation == "demandeur") ? true : false,
        "Inscrit": (this.Emploi == "demandeur") ? true : false
      },
    }

    this.stagiaire1 = {
      "numSecu": this.nss,
      "nom": this.nom,
      "prenom": this.prenom,
      "datenaissance": new Date(this.datenaissance),
      "adresse": this.adress1,
      "civilite": "mr", //this.mr,
      "diplome": this.diplome,
      "niveau_entree": this.niveauFormation,
      "difficulte": (this.diffiulte == "Oui") ? true : false,
      "enfant": (this.enfants == "Oui") ? true : false,
      "parent_francais": this.parents,
      "logement": this.logement,
      "risque_perte_logement": (this.perdrelogement == "Oui") ? true : false,
      
      "origine_formation": this.structureSelect,
      "allocation": this.allocationSelect,

      "handicape": false,

      "session": {
        "id": 1,
        "libelle": "CQF",
        "date_debut": new Date("2021-09-16") ,
        "date_fin": new Date("2021-09-24") 
      },
      //"libelle" : this.nSession,
      //"date_debut" :  Date(this.dateEntre),
      //"date_fin" : this.dateSortie,
      "domtom": this.DOM,
      "situation": this.Vivez,
      "nbr_travailleur": this.foyer,
      "transport": this.transportSelect,
      "hebergement": {
        "id": "1",
        "libelle": "Arrondissement d'Abbeville",
        "abrv": "AABB"
      },
      "situationProfessionnelle": {
        "salarie": (this.situation == "salarie") ? true : false,
        "demandeur_emploi": (this.situation == "demandeur") ? true : false,
        "Inscrit": (this.Emploi == "demandeur") ? true : false
      },
      "villeHabitation": {
        "id": 1,
        "libelle": "LILLE",
        "departement": {
          "id": 1,
          "libelle": "NORD",
          "num_departement": 59,
          "code_commune": 0,
          "pays": {
            "id": 3,
            "libelle": "FR",
            "abv": "FRANCE"
          }
        }
      },
      "villeNaissance": {
        "id": 1,
        "libelle": "LILLE",
        "departement": {
          "id": 1,
          "libelle": "NORD",
          "num_departement": 59,
          "code_commune": 0,
          "pays": {
            "id": 3,
            "libelle": "FR",
            "abv": "FRANCE"
          }
        }
      },
      "signature": "",
      "compte": {
        "id": 24,
        "email": "congue@hotmail.org",
        "mdp": "NYO14XJH6AI"
      }
    }
    console.log(this.stagiaire1)
    this.stagiaireService.save(this.stagiaire1).subscribe();

  }
}
