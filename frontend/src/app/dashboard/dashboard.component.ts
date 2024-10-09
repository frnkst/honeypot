import { Component } from '@angular/core';
import {LiveAttacksComponent} from "../components/live-attacks/live-attacks.component";
import {TopPasswordsComponent} from "../components/top-passwords/top-passwords.component";
import {TopUsernamesComponent} from "../components/top-usernames/top-usernames.component";
import {TopIpsComponent} from "../components/top-ips/top-ips.component";
import {
  TopPasswordsContainerComponent
} from "../components/top-passwords/top-passwords-container.component";

@Component({
  selector: 'app-dashboard',
  standalone: true,
  imports: [
    LiveAttacksComponent,
    TopUsernamesComponent,
    TopIpsComponent,
    TopPasswordsContainerComponent
  ],
  templateUrl: './dashboard.component.html',
  styleUrl: './dashboard.component.scss'
})
export class DashboardComponent {

}
