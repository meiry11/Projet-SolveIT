import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { UntypedFormBuilder, UntypedFormGroup } from '@angular/forms';
import { Utilisateur } from 'src/app/models/utilisateur.model';

@Component({
  selector: 'app-utilisateur-formulaire',
  templateUrl: './utilisateur-formulaire.component.html',
  styleUrls: ['./utilisateur-formulaire.component.scss']
})
export class UtilisateurFormulaireComponent implements OnInit {
  @Input()
  default?: Utilisateur;
  @Output() 
  finish = new EventEmitter();

  form:UntypedFormGroup = new UntypedFormGroup({});
  constructor(private builder: UntypedFormBuilder) {

   }

  ngOnInit(): void {
    this.form =this.builder.group({
      "nom": [this.default?.nom||''],
      "prenom": [this.default?.prenom||'']
    });  
  }

  onSubmit(){
   this.finish.emit(this.form.value);
  }



}
