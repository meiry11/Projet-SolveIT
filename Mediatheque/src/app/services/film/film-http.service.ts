import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { Film } from 'src/app/models/Film.model'

const apiUrlFilm = environment.API_URL+"/Films"
@Injectable({
  providedIn: 'root'
})
export class FilmHttpService {

  constructor(private http:HttpClient) { }

  findAll(){
    return this.http.get<Film[]>(apiUrlFilm);
  }

  findById(id:number){
    return this.http.get<Film>(`${apiUrlFilm}/${id}`);
  }

  save(film:Film){
    return this.http.post<Film>(apiUrlFilm,film);
  }

  delete(id:number){
    return this.http.delete<Film>(`${apiUrlFilm}/${id}`);
  }
}
