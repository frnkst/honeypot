import { Component } from '@angular/core';
import {LiveAttacksComponent} from "../components/live-attacks/live-attacks.component";
import {TopPasswordsComponent} from "../components/top-passwords/top-passwords.component";
import {TopUsernamesComponent} from "../components/top-usernames/top-usernames.component";

@Component({
  selector: 'app-dashboard',
  standalone: true,
  imports: [
    LiveAttacksComponent,
    TopPasswordsComponent,
    TopUsernamesComponent
  ],
  templateUrl: './dashboard.component.html',
  styleUrl: './dashboard.component.scss'
})
export class DashboardComponent {

}
