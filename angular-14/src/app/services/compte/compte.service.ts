import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../../environments/environment';
import { Compte } from '../../models/compte.model';


const apiUrlCompte = environment.API_URL+"/comptes"
@Injectable({
  providedIn: 'root'
})
export class CompteService {

  constructor(private http:HttpClient) { }

  findAll(){
    return this.http.get<Compte[]>(apiUrlCompte);
  }

  findById(id:number){
    return this.http.get<Compte>(`${apiUrlCompte}/${id}`);
  }

  save(hebergement:any){
    return this.http.post<Compte>(apiUrlCompte,hebergement);
  }

  delete(id:number){
    return this.http.delete<Compte>(`${apiUrlCompte}/${id}`);
  }
}
