import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import {MatNativeDateModule} from '@angular/material/core';


import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { ComponentsRoutes } from './component.routing';
import { NgbdpaginationBasicComponent } from './pagination/pagination.component';
import { NgbdAlertBasicComponent } from './alert/alert.component';
import { NgbdDropdownBasicComponent } from './dropdown-collapse/dropdown-collapse.component';
import { NgbdnavBasicComponent } from './nav/nav.component';
import { ButtonsComponent } from './buttons/ajout/buttons.component';
import { ButtonsModifyComponent } from './buttons/modifier/buttons.component';
import { ButtonsDeleteComponent } from './buttons/supprimer/buttons.component';
import { CardsComponent } from './card/card.component';
import { CardEmploiComponent } from './cardEmploi/card.component';
import { TableComponent } from "./table/table.component";
import { SearchBarComponent } from './search-bar/search-bar.component';
import { DataTablesModule } from 'angular-datatables';
import { FormulaireEmargementComponent } from './formulaire-emargement/formulaire-emargement.component';
import { CalendrierComponent } from './calendrier/calendrier.component';
import {MatCheckboxModule} from '@angular/material/checkbox';
import {MatRadioModule} from '@angular/material/radio';
import {MatAutocompleteModule} from '@angular/material/autocomplete';

import { FullCalendarModule } from '@fullcalendar/angular';
import dayGridPlugin  from '@fullcalendar/daygrid';
import interactionPlugin from '@fullcalendar/interaction';
import { TableEmargementComponent } from './formulaire-emargement/table-emargement/table-emargement.component';
import { EnregistrerComponent } from './buttons/enregistrer/enregistrer.component';
import { ImprimerComponent } from './buttons/imprimer/imprimer.component';
import { AnnulerComponent } from './buttons/annuler/annuler.component';
import { InscriptionStagiaireComponent } from './inscription-stagiaire/inscription-stagiaire.component';
import { Page1Component } from './inscription-stagiaire/page1/page1.component';
import { Page2Component } from './inscription-stagiaire/page2/page2.component';
import { Page3Component } from './inscription-stagiaire/page3/page3.component';
import { FormFieldOverviewFormComponent } from './form-field-overview-form/form-field-overview-form.component';

import {MatFormFieldModule} from '@angular/material/form-field';
import {MatSelectModule} from '@angular/material/select';
import {Approutes} from "../app-routing.module";






FullCalendarModule.registerPlugins([ // register FullCalendar plugins
dayGridPlugin,
  interactionPlugin
]);

@NgModule({
  imports: [
    CommonModule,
    RouterModule.forChild(ComponentsRoutes),
    FormsModule,
    ReactiveFormsModule,
    NgbModule,
    DataTablesModule,
    FullCalendarModule,
    MatCheckboxModule,
    MatRadioModule,
    MatNativeDateModule,
    MatFormFieldModule,
    MatSelectModule,
    MatAutocompleteModule

  ],
  declarations: [
    NgbdpaginationBasicComponent,
    NgbdAlertBasicComponent,
    NgbdDropdownBasicComponent,
    NgbdnavBasicComponent,
    ButtonsComponent,
    ButtonsModifyComponent,
    ButtonsDeleteComponent,
    CardsComponent,
    CardEmploiComponent,
    TableComponent,
    SearchBarComponent,
    FormulaireEmargementComponent,
    CalendrierComponent,
    TableEmargementComponent,
    EnregistrerComponent,
    ImprimerComponent,
    AnnulerComponent,
    InscriptionStagiaireComponent,
    Page1Component,
    Page2Component,
    Page3Component,
    FormFieldOverviewFormComponent,


  ]
})
export class ComponentsModule { }
