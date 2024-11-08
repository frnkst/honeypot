import {Component} from '@angular/core';
import {fromUnixTime} from "date-fns";
import {AttackService, MostRecent} from "../../services/test.service";
import {Observable} from "rxjs";
import {AsyncPipe} from "@angular/common";

@Component({
  selector: 'app-live-attacks',

  standalone: true,
  imports: [
    AsyncPipe
  ],
  templateUrl: './live-attacks.component.html',
  styleUrl: './live-attacks.component.scss'
})
export class LiveAttacksComponent {
  attackEvents: Observable<MostRecent[]>;

  constructor(private attackService: AttackService) {
    this.attackEvents = this.attackService.getMostRecentAttempts();
  }


  protected readonly fromUnixTime = fromUnixTime;
  protected readonly Number = Number;
}
