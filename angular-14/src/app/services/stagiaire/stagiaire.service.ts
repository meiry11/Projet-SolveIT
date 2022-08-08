import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Obj } from '@popperjs/core';
import { environment } from '../../../environments/environment';


const apiUrlStagiaire = environment.API_URL+"/utilisateurs/stagiaires"
const apiUrlUtilisateur = environment.API_URL+"/utilisateurs"

@Injectable({
  providedIn: 'root'
})
export class StagiaireService {

  constructor(private http:HttpClient) { }

  findAll(){
    return this.http.get<Object[]>(apiUrlStagiaire);
  }

  findById(numSecu:string){
    return this.http.get<Object>(`${apiUrlStagiaire}/${numSecu}`);
  }
  findBySession( lib:String,date_debut:String, date_fin:String){ 
    return this.http.get<Object>(`${apiUrlStagiaire}/${lib}/${date_debut}/${date_fin}`);
  }


  save(stagiaire:any){
    return this.http.post<Object>(apiUrlUtilisateur,stagiaire);
  }

  delete(numSecu:string){
    return this.http.delete<Object>(`${apiUrlUtilisateur}/${numSecu}`);
  }
}
