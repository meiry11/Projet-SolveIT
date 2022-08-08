// import des module d angular
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule,ReactiveFormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FirstComponentComponent } from './components/first-component/first-component.component';
import { SecondeComponentComponent } from './components/seconde-component/seconde-component.component';
import { UserComponent } from './components/user/user.component';
import { CarteVisiteComponent } from './components/carte-visite/carte-visite.component';
import { AlertButtonComponent } from './components/alert-button/alert-button.component';
import { ListeComponent } from './components/liste/liste.component';
import { MagieComponent } from './components/magie/magie.component';
import { ListeFiltreComponent } from './components/liste-filtre/liste-filtre.component';
import { PipeComponent } from './components/pipe/pipe.component';
import { GenericAlertButtonComponent } from './components/generic-alert-button/generic-alert-button.component';
import { ButtonMenuComponent } from './components/button-menu/button-menu.component';
import { ListeCoursesComponent } from './components/liste-courses/liste-courses.component';
import { ReactiveListeCoursesComponent } from './components/reactive-liste-courses/reactive-liste-courses.component';
import { FormbuiledListeCoursesComponent } from './components/formbuiled-liste-courses/formbuiled-liste-courses.component';
import { DataCoursesComponent } from './components/OutputListeCourses/data-courses/data-courses.component';
import { FormCoursesComponent } from './components/OutputListeCourses/form-courses/form-courses.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatSliderModule } from '@angular/material/slider'
import { HttpClientModule} from '@angular/common/http';
import { UtilisateurFormulaireComponent } from './components/utilisateur-formulaire/utilisateur-formulaire.component';
import { UtilisateurCardComponent } from './components/utilisateur-card/utilisateur-card.component'
// decorateur
@NgModule({
  declarations: [
    AppComponent,
    FirstComponentComponent,
    SecondeComponentComponent,
    UserComponent,
    CarteVisiteComponent,
    AlertButtonComponent,
    ListeComponent,
    MagieComponent,
    ListeFiltreComponent,
    PipeComponent,
    GenericAlertButtonComponent,
    ButtonMenuComponent,
    ListeCoursesComponent,
    ReactiveListeCoursesComponent,
    FormbuiledListeCoursesComponent,
    DataCoursesComponent,
    FormCoursesComponent,
    UtilisateurFormulaireComponent,
    UtilisateurCardComponent
  ],
  // module : fonctionnalité creer par angular
  // on declare ici les modules à empoter
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    MatSliderModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
