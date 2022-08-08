import { Routes } from '@angular/router';
import { NgbdpaginationBasicComponent } from './pagination/pagination.component';
import { NgbdAlertBasicComponent } from './alert/alert.component';

import { NgbdDropdownBasicComponent } from './dropdown-collapse/dropdown-collapse.component';
import { NgbdnavBasicComponent } from './nav/nav.component';
import { BadgeComponent } from './badge/badge.component';
import { ButtonsComponent } from './buttons/ajout/buttons.component';
import { ButtonsModifyComponent } from './buttons/modifier/buttons.component';
import { ButtonsDeleteComponent } from './buttons/supprimer/buttons.component';
import { CardsComponent } from './card/card.component';
import { CardEmploiComponent } from './cardEmploi/card.component';
import { CalendrierComponent } from './calendrier/calendrier.component';
import { TableComponent } from './table/table.component';
import { InscriptionStagiaireComponent} from './inscription-stagiaire/inscription-stagiaire.component'
import { FormulaireEmargementComponent } from './formulaire-emargement/formulaire-emargement.component'
import { FormFieldOverviewFormComponent } from './form-field-overview-form/form-field-overview-form.component';


export const ComponentsRoutes: Routes = [
	{
		path: '',
		children: [
			{
				path: 'table',
				component: TableComponent
			},
			{
				path: 'calendrier',
				component: CalendrierComponent
			},
			{
				path: 'cardEmploi',
				component: CardEmploiComponent
			},
			{
				path: 'card',
				component: CardsComponent
			},
			{
				path: 'pagination',
				component: NgbdpaginationBasicComponent
			},
			{
				path: 'badges',
				component: BadgeComponent
			},
			{
				path: 'NouvelleFeuille/:num',
				component: FormulaireEmargementComponent
			},
			{
				path: 'NouvelleFeuille',
				component: FormulaireEmargementComponent
			},
			{
				path: 'InscriptionStagiaire',
				component: InscriptionStagiaireComponent
			},
			{
				path: 'alert',
				component: NgbdAlertBasicComponent
			},
			{
				path: 'dropdown',
				component: NgbdDropdownBasicComponent
			},
			{
				path: 'nav',
				component: NgbdnavBasicComponent
			},
			{
				path: 'buttons',
				component: ButtonsComponent
			},
			{
				path: 'formulaire',
				component: FormFieldOverviewFormComponent
			}
		]
	}
];
