import { Component } from '@angular/core';
import {LiveAttacksComponent} from "../components/live-attacks/live-attacks.component";
import {
  TopContainerComponent
} from "../components/top/top-container.component";
import {AllStatsContainerComponent} from "../components/all-stats/all-stats-container.component";

@Component({
  selector: 'app-dashboard',
  standalone: true,
  imports: [
    LiveAttacksComponent,
    TopContainerComponent,
    AllStatsContainerComponent
  ],
  templateUrl: './dashboard.component.html',
  styleUrl: './dashboard.component.scss'
})
export class DashboardComponent {

}
