import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Tarea} from '../models/tarea';

@Injectable({
  providedIn: 'root',
})
export class TareaService {

  private url: string = 'http://localhost:8080';
  constructor(private http: HttpClient) {
  }

  getTareas(): Observable<Tarea[]> {
    return this.http.get<Tarea[]>(this.url+'/tareas');
  }
}
