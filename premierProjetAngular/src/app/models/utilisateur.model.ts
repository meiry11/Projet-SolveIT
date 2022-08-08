
export class Utilisateur{
    constructor(
        public id: number = -1,
        public nom : string,
        public prenom : string
    ){}
}

export interface utilisateur{
     id: number,
     nom : string,
     prenom : string
}