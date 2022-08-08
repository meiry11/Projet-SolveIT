export class Utilisateur{
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
    ){}
}