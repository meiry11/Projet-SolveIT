import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from '../../../environments/environment';

const apiUrlHebergement = environment.API_URL+"/hebergement"
@Injectable({
  providedIn: 'root'
})
export class HebergementService {

  constructor(private http:HttpClient) { }

  findAll(){
    return this.http.get<Object[]>(apiUrlHebergement);
  }

  findById(id:number){
    return this.http.get<Object>(`${apiUrlHebergement}/${id}`);
  }

  save(hebergement:Object){
    return this.http.post<Object>(apiUrlHebergement,hebergement);
  }

  delete(id:number){
    return this.http.delete<Object>(`${apiUrlHebergement}/${id}`);
  }
}
