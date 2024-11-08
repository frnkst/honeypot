import { Component } from '@angular/core';
import {AttackService, MostRecent} from "../../services/test.service";
import {Observable} from "rxjs";

@Component({
  selector: 'app-recent-attacks',
  standalone: true,
  imports: [],
  templateUrl: './recent-attacks.component.html',
  styleUrl: './recent-attacks.component.scss'
})
export class RecentAttacksComponent {
  attackEvents: Observable<MostRecent[]>;

  constructor(private attackService: AttackService) {
    this.attackEvents = this.attackService.getMostRecentAttempts();
  }
}
