import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../../environments/environment';


const apiUrlAbsence = environment.API_URL+"/absences"
@Injectable({
  providedIn: 'root'
})
export class AbsenceServiceService {

  constructor(private http:HttpClient) { }

  findAll(){
    return this.http.get<Object[]>(apiUrlAbsence);
  }

  findById(id:any){
    return this.http.get<Object>(`${apiUrlAbsence}/${id}`);
  }

  save(absence:any){
    return this.http.post<Object>(apiUrlAbsence,absence);
  }

  delete(id:any){
    return this.http.delete<Object>(`${apiUrlAbsence}/${id}`);
  }
}
