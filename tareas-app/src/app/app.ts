import {Component, OnInit, signal} from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-root',
  imports: [],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App implements OnInit{

  protected readonly title = signal('tareas-app');

  tareas: any[] = [];
  private url: string = 'http://localhost:8080';

  constructor(private http: HttpClient) {
  }

  ngOnInit() {
    this.http.get<any>(this.url+'/tareas').subscribe(
      data => {
        this.tareas = data;
      }
    );
  }

}
