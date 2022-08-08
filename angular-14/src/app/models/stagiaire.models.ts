import { Compte } from "./compte.model";
import { Utilisateur } from "./Utilisateur.models";

export class Stagiaire extends Utilisateur{
    constructor(
        public numSecu: String,
        public nom: String,
        public prenom: String,
        public datenaissance: Date,
        public adresse: String,
        public civilite: String,
        public compte: any,
        public villeHabitation: any,
        public villeNaissance: any,
        public diplome: String,
        public niveau_entree: String,
        public difficulte: boolean,
        public handicape: boolean,
        public domtom: String,
        public situation: String,
        public nbr_travailleur: String,
        public enfant: boolean,
        public logement: String,
        public parent_francais: String,
        public risque_perte_logement: boolean,
        public origine_formation: String,
        public transport: String,
        public allocation: String,
        public signature: any,
        public session: any,
        public hebergement:  any,
        public situationProfessionnelle: any,
    ){super(numSecu,nom,prenom,datenaissance,adresse,civilite,compte,villeHabitation,villeNaissance)}
}