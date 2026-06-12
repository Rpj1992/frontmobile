import {Component, OnInit, signal} from '@angular/core';
import {TareaService} from './services/tareaService';
import {Tarea} from './models/tarea';
import {ReactiveFormsModule, FormControl, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-root',
  imports: [ReactiveFormsModule],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App implements OnInit{

  protected readonly title = signal('tareas-app');

  tareas: Tarea[] = [];

  formularioTarea = new FormGroup({
    titulo: new FormControl('', {
      nonNullable: true,
      validators: [Validators.required, Validators.minLength(3)]
    }),
    completada: new FormControl(false, {
      nonNullable: true,
    })
  });

  constructor(private tareaService: TareaService) {
  }

  ngOnInit(): void {
    this.cargarTareas();
  }

  cargarTareas(): void {
    this.tareaService.getTareas().subscribe(
      data => {
        //console.log(data);
        this.tareas = [...data];
      }
    );
  }

  crearTarea(): void {
    if (this.formularioTarea.invalid) {
      this.formularioTarea.markAllAsTouched();
      return;
    }

    const nuevaTarea: Partial<Tarea> = this.formularioTarea.getRawValue();

    this.tareaService.crearTarea(nuevaTarea).subscribe(tareaCreada => {
      this.tareas = [...this.tareas, tareaCreada];
      this.formularioTarea.reset({
        titulo: '',
        completada: false
      });
      this.cargarTareas();
    });
  }

}
