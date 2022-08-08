// import du decorateur component
import { Component } from '@angular/core';
import { Utilisateur } from './models/utilisateur.model';
import { UtilisateurHttpService } from './services/utilisateur-http.service';

// appelle du decorateur avec @component
// il va dire que cette classe est un composant
@Component({
  // le nom de la balise qui va appeler le composant
  selector: 'app-root', // <app-root> </app-root>
  // permet de recupere fichier html
  templateUrl: './app.component.html',
  // permet de recupere fichier style de notre composant
  styleUrls: ['./app.component.scss']
})
// la classe appcomponent qui est crée
export class AppComponent {
  title = 'premierProjetAngular';
  utilisateurs: Utilisateur[] = [];
  editutilisateur?:Utilisateur;
  constructor(private service:UtilisateurHttpService){
    this.service.findAll().subscribe((data) => this.utilisateurs = data);
  }

  onSave(utilisateur:Utilisateur){
    
    //alert(utilisateur);
    this.service.save(utilisateur).subscribe((newutilisateur) => this.utilisateurs.push(newutilisateur));
  }

  onDelete(id:number){
    this.service.delete(id).subscribe(() => this.utilisateurs = this.utilisateurs.filter(utilisateur => utilisateur.id !== id));
  }
  onModifier(utilisateur:Utilisateur){
    alert(utilisateur.id)
    //this.form
    this.editutilisateur= utilisateur;

  }
}
