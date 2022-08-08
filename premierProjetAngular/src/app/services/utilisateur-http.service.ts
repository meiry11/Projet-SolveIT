import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { utilisateur } from '../models/utilisateur.model';

const apiUrl = environment.API_URL+"/utilisateurs";
@Injectable({
  providedIn: 'root'
})
export class UtilisateurHttpService {
  
  constructor(private http:HttpClient) { }

  findAll(){
   // return this.http.get("http://localhost:3000/utilisateurs");
   return this.http.get<utilisateur[]>(apiUrl);
  }

  save(utilisateur:utilisateur){
    // return this.http.get("http://localhost:3000/utilisateurs");
    return this.http.post<utilisateur>(apiUrl,utilisateur);
   }

   delete(id:number){
    // return this.http.get(apiUrl);
    return this.http.delete<utilisateur>(`${apiUrl}/${id}`);
   }


}
