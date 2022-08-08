import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../../environments/environment';


const apiUrlFeuilleEmargement = environment.API_URL+"/feuilleemargements"
@Injectable({
  providedIn: 'root'
})
export class FeuilleEmargementService {

  constructor(private http:HttpClient) { }

  findAll(){
    return this.http.get<Object[]>(apiUrlFeuilleEmargement);
  }

  findById(num:string){
    return this.http.get<Object>(`${apiUrlFeuilleEmargement}/${num}`);
  }

  save(feuilleEmargement:any){
    return this.http.post<Object>(apiUrlFeuilleEmargement,feuilleEmargement);
  }

  delete(num:string){
    return this.http.delete<Object>(`${apiUrlFeuilleEmargement}/${num}`);
  }
}
