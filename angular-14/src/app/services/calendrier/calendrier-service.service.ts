import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../../environments/environment';


const apiUrlCalendrier = environment.API_URL+"/calendriers"
@Injectable({
  providedIn: 'root'
})
export class CalendrierServiceService {

  constructor(private http:HttpClient) { }

  findAll(){
    return this.http.get<Object[]>(apiUrlCalendrier);
  }

  findById(id:any){
    return this.http.get<Object>(`${apiUrlCalendrier}/${id}`);
  }

  save(calendrier:any){
    return this.http.post<Object>(apiUrlCalendrier,calendrier);
  }

  delete(id:any){
    return this.http.delete<Object>(`${apiUrlCalendrier}/${id}`);
  }
}
