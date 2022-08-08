import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { Utilisateur } from 'src/app/models/utilisateur.model';

@Component({
  selector: 'app-utilisateur-card',
  templateUrl: './utilisateur-card.component.html',
  styleUrls: ['./utilisateur-card.component.scss']
})
export class UtilisateurCardComponent implements OnInit {
  @Input()
  utilisateur!: Utilisateur;
  @Output()
  delete = new EventEmitter();
  @Output()
  modifier = new EventEmitter();

  constructor() { }

  ngOnInit(): void {
  }

  onDelete(){
    this.delete.emit(this.utilisateur.id);
  }

  onUpdate(){
    this.modifier.emit(this.utilisateur);
  }

}
