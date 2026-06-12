import {Component, OnInit, signal} from '@angular/core';
import {TareaService} from './services/tareaService';
import {Tarea} from './models/tarea';

@Component({
  selector: 'app-root',
  imports: [],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App implements OnInit{

  protected readonly title = signal('tareas-app');

  tareas: Tarea[] = [];

  constructor(private tareaService: TareaService) {
  }

  ngOnInit() {
    this.tareaService.getTareas().subscribe(
      data => {
        //console.log(data);
        this.tareas = data;
        //console.log(this.tareas);
      }
    );
  }

}
