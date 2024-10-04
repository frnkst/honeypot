import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {LoginsComponent} from "./logins/logins.component";

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, LoginsComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent {
  title = 'frontend';
}
