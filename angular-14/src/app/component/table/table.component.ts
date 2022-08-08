import { Component, EventEmitter, Input, OnDestroy, OnInit, Output } from '@angular/core';
import { Subject } from 'rxjs';

import { DataTablesModule } from 'angular-datatables';
import { HttpClient } from '@angular/common/http';
import { StagiaireService } from '../../services/stagiaire/stagiaire.service';
import { FeuilleEmargementService } from '../../services/feuilleEmargement/feuille-emargement.service';
import { environment } from '../../../environments/environment';
import { Router } from '@angular/router';


const apiUrlStagiaire = environment.API_URL+"/utilisateurs/stagiaires"



@Component({
    selector: 'app-table',
    templateUrl: 'table.component.html'
})
export class TableComponent implements OnDestroy, OnInit{
  @Input()
  chemin!:string;
  @Input()
  apiUrl:string="";
  hidden: boolean=true;
  id: number=-1;
  type_tab!:string;
  @Output()
  onSupp: EventEmitter<any> = new EventEmitter();



  dtOptions: DataTables.Settings = {};
  persons!: any;
  // We use this trigger because fetching the list of persons can be quite long,
  // thus we ensure the data is fetched before rendering
  dtTrigger: Subject<any> = new Subject<any>();

  constructor(private route:Router,private httpClient: HttpClient,private stagiareService:StagiaireService,private feuilleEmargementService: FeuilleEmargementService) {

  }

  ngOnInit(): void {



    this.dtOptions = {
      pagingType: 'full_numbers',
      pageLength: 10,
      data: this.persons,
      language: {
        processing: "Procesando...",
        search: "Filtrer:",
        lengthMenu: "Afficher _MENU_ &eacute;l&eacute;ments",
        info: "Afficher de _START_ à _END_ depuis _TOTAL_ elements",
        infoEmpty: "Aucune information",
        infoFiltered: "(filtrado _MAX_ elementos total)",
        infoPostFix: "",
        loadingRecords: "Cargando registros...",
        zeroRecords: "No se encontraron registros",
        emptyTable: "Pas de donnèe trouvée",
        paginate: {
          first: "<<",
          previous: "<",
          next: ">",
          last: ">>"
        },
        aria: {
          sortAscending: ": Activar para ordenar la tabla en orden ascendente",
          sortDescending: ": Activar para ordenar la tabla en orden descendente"
        }
      },
    
    };
 /*   this.stagiareService.findAll().subscribe((data) => {
      this.persons = data;
      // Calling the DT trigger to manually render the table
      this.dtTrigger.next(null);

    });*/
    if (this.apiUrl == ""){
        this.httpClient.get<Object[]>(apiUrlStagiaire).subscribe(data => {
          this.persons = data;
          this.dtTrigger.next(null);

        });
        this.type_tab="stagiaire";
        this.chemin="/component/InscriptionStagiaire";
    }else{
      this.httpClient.get<Object[]>(this.apiUrl).subscribe(data => {
        this.persons = data;
        this.dtTrigger.next(null);

      });
      this.type_tab="feuille";
    }

 /*       this.stagiareService.findAll().subscribe(data => {
      this.persons = data;
      // Calling the DT trigger to manually render the table
      this.dtTrigger.next(data);
    });*/
  }

  ngOnDestroy(): void {
    // Do not forget to unsubscribe the event
    this.dtTrigger.unsubscribe();
  }
  toggle(i:number){
    this.id=i
    this.hidden= !this.hidden;


}
onDelete(){
  if(this.chemin == "/component/NouvelleFeuille"){
    this.feuilleEmargementService.delete(this.persons[this.id].num).subscribe(() => this.persons = this.persons.filter((person: { num: any; }) => person.num !== this.id));
    
    this.onSupp.emit(this.persons.value);
  }
  
}

}
