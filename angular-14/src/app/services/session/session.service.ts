import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from '../../../environments/environment';


const apiUrlSession = environment.API_URL+"/session"
@Injectable({
  providedIn: 'root'
})
export class SessionService {

  constructor(private http :HttpClient) { }

  findAllSessions():Observable<any[]>{

    return this.http.get<any[]>(apiUrlSession);
  }
}
